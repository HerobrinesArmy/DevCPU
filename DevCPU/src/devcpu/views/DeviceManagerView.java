package devcpu.views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.part.ViewPart;

import devcpu.Activator;
import devcpu.ViewMapper;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.DefaultControllableDCPU;
import devcpu.emulation.FloppyDisk;
import devcpu.emulation.Identifiable;
import devcpu.emulation.VirtualFloppyDrive;
import devcpu.emulation.VirtualKeyboard;
import devcpu.emulation.VirtualMonitor;
import devcpu.emulation.VirtualVectorDisplay;
import devcpu.managers.DCPUManager;
import devcpu.managers.DeviceRegistration;
import devcpu.managers.FloppyManager;
import devcpu.managers.HardwareManager;
import devcpu.managers.HardwareRegistry;
import devcpu.util.Util;
import devcpu.views.hex.DCPUMemoryDataProvider;
import devcpu.views.hex.HexView;

public class DeviceManagerView extends ViewPart {
	public static final String ID = "devcpu.views.DeviceManagerView";
	private TreeViewer treeViewer;
	private DeviceManagerContentProvider contentProvider;
	private DeviceManagerLabelProvider labelProvider;
	
	public void createPartControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		contentProvider = DeviceManagerContentProvider.get();
		labelProvider = DeviceManagerLabelProvider.get();
		treeViewer = new TreeViewer(container, SWT.NONE);
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(labelProvider);
		treeViewer.setInput(Activator.getDefault());
		treeViewer.expandAll();
		
	  final MenuManager menuMgr = new MenuManager();
	  Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
	  menuMgr.addMenuListener(new IMenuListener() {
	    @Override
	    public void menuAboutToShow(IMenuManager manager) {
	      if(treeViewer.getSelection().isEmpty()) {
	        return;
	      }
	      
	      if(treeViewer.getSelection() instanceof IStructuredSelection) {
	        IStructuredSelection selection = (IStructuredSelection)treeViewer.getSelection();
	        Object o = selection.getFirstElement();
	        
	        if (o instanceof Identifiable)
	        {
	        	final Identifiable identifiable = (Identifiable) o;
	        	menuMgr.add(new Action("Rename...") {
	        		@Override
	        		public void run() {
	        			InputDialog dialog = new InputDialog(container.getShell(), "Rename", "New name:", identifiable.getID(), null);
								dialog.setBlockOnOpen(true);
								int result = dialog.open();
								if (result == Window.OK) {
									identifiable.setID(dialog.getValue());
									treeViewer.refresh();
								}
	        		}
	        	});
	        	
      			//TODO: Add confirm dialog for all of these destroys? Or keep it this way for quick destruction? Maybe use preference.
	        	if (o instanceof DefaultControllableDCPU) {
	          	final DefaultControllableDCPU dcpu = (DefaultControllableDCPU) o;
	          	manager.add(new Action("Destroy") {
	          		public void run() {
	          			Activator.getShip().getDCPUManager().destroyDCPU(dcpu);
	          			treeViewer.refresh();
	          		};
	  					});
	        	} else if (o instanceof DCPUHardware) {
		        	final DCPUHardware hardware = (DCPUHardware) o;
		        	manager.add(new Action("Destroy") {
		        		public void run() {
		        			Activator.getShip().getHardwareManager().destroyDevice(hardware);
		        			treeViewer.refresh();
		        		};
							});
	        	} else if (o instanceof FloppyDisk) {
		        	final FloppyDisk disk = (FloppyDisk) o;
		        	manager.add(new Action("Destroy") {
		        		public void run() {
		        			Activator.getShip().getFloppyManager().destroyDisk(disk);
		        			treeViewer.refresh();
		        		};
							});
	        	}
	        	
	        	menuMgr.add(new Separator());
	        }
	        
	        if (o instanceof DCPUHardware) {
	        	final DCPUHardware hardware = (DCPUHardware) o;
	        	if (hardware.isConnected()) {
		        	manager.add(new Action("Disconnect") {
		        		public void run() {
		        			hardware.disconnect();
		        			treeViewer.refresh();
		        		};
							});
	        	}
	        }
	        
	        if (o instanceof DCPUManager) {
	        	final DCPUManager dcpuManager = (DCPUManager) o;
	        	manager.add(new Action("Add DCPU") {
	        		@Override
    	    		public ImageDescriptor getImageDescriptor() {
    	    			return Util.getImageDescriptor("icons/dcpu.png");
    	    		}
    	    		public void run() {
	        			DefaultControllableDCPU dcpu = dcpuManager.createDCPU();
	        			treeViewer.expandToLevel(dcpu, 0);
	        			treeViewer.refresh();
	        		};
						});
	        } else if (o instanceof FloppyManager) {
	        	final FloppyManager floppyManager = (FloppyManager) o;
	        	manager.add(new Action("Add Floppy") {
	        		@Override
    	    		public ImageDescriptor getImageDescriptor() {
    	    			return Util.getImageDescriptor("icons/disk.png");
    	    		}
    	    		public void run() {
	        			FloppyDisk disk = floppyManager.createFloppyDisk();
	        			treeViewer.expandToLevel(disk, 0);
	        			treeViewer.refresh();
	        		};
						});
	        } else if (o instanceof FloppyDisk) {
	        	final FloppyDisk disk = (FloppyDisk) o;
	        	manager.add(new Action("Dump to file...") {
	        		public void run() {
	        			FileDialog fd = new FileDialog(container.getShell(), SWT.SAVE);
	              fd.setText("Save binary file (big endian)");
	              String selected = fd.open();
	              if (selected != null) {
	              	try {
										disk.save(new File(selected));
									} catch (IOException e) {
										e.printStackTrace();
									}
	              }
	        			treeViewer.refresh();
	        		};
						});
	        	if (disk.getDriveUsing() == null) {
		        	if (disk.isWriteProtected()) {
		        		manager.add(new Action("Unprotect") {
			        		public void run() {
			        			disk.setWriteProtected(false);
			        			treeViewer.refresh();
			        		};
								});
		        	} else {
		        		manager.add(new Action("Write from file...") {
			        		public void run() {
			        			FileDialog fd = new FileDialog(container.getShell(), SWT.OPEN);
			              fd.setText("Load binary file (big endian)");
			              String selected = fd.open();
			              if (selected != null) {
			              	try {
												disk.load(new File(selected));
											} catch (IOException e) {
												e.printStackTrace();
											}
			              }
			        			treeViewer.refresh();
			        		};
								});
		        		manager.add(new Action("Protect") {
			        		public void run() {
			        			disk.setWriteProtected(true);
			        			treeViewer.refresh();
			        		};
								});
		        	}
	        	} else {
	        		manager.add(new Action("Eject") {
		        		public void run() {
		        			disk.getDriveUsing().eject();
		        			treeViewer.refresh();
		        		};
							});
	        	}
	        } else if (o instanceof HardwareManager) {
        	final HardwareManager hardwareManager = (HardwareManager) o;
        	MenuManager hardwareMenu = new MenuManager("Add Hardware", Util.getImageDescriptor("icons/hw.png"),null);
      	  hardwareMenu.addMenuListener(new IMenuListener() {
      	    @Override
      	    public void menuAboutToShow(IMenuManager manager) {
      	    	for (final DeviceRegistration device : HardwareRegistry.getDevices())
      	    	{
    	    			manager.add(new Action(device.getName()) {
									@Override
    	    				public ImageDescriptor getImageDescriptor() {
										return device.getIconDescriptor();
    	    				}
    	    				public void run() {
    	    					DCPUHardware hw = hardwareManager.createHardware(device);
    	    					if (hw != null)
    	    					{
    	    						treeViewer.expandToLevel(hw, 0);
    	    						treeViewer.refresh();
    	    					}
    	    					else
    	    					{
    	    						//TODO: exception?
    	    					}
    	    				}
    	    			});
    	    		}
      	    }
      	  });
      	  hardwareMenu.setRemoveAllWhenShown(true);
      	  menuMgr.add(hardwareMenu);
        } else if (o instanceof DefaultControllableDCPU) {
        	final DefaultControllableDCPU dcpu = (DefaultControllableDCPU) o;
 	    		manager.add(new Action("View RAM") {
  	    		public void run() {
  	    			try {
								IViewPart v = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(HexView.VIEW_ID, dcpu.getID(), IWorkbenchPage.VIEW_CREATE);
								HexView hv = (HexView) v;
								hv.setDataProvider(new DCPUMemoryDataProvider(dcpu));
							} catch (PartInitException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
  	    			treeViewer.refresh();
  	    		};
  	    	});
	    		if (dcpu.isRunning()) {
	    			manager.add(new Action("Stop") {
	    				@Override
    	    		public ImageDescriptor getImageDescriptor() {
    	    			return Util.getImageDescriptor("icons/stop.png");
    	    		}
    	    		public void run() {
    	    			try {
									dcpu.getDebugTarget().terminate();
								} catch (DebugException e) {
									e.printStackTrace();
								}
    	    			treeViewer.refresh();
    	    		};
    	    	});
	    		} else {
	 	    		manager.add(new Action("Start") {
	 	    			@Override
    	    		public ImageDescriptor getImageDescriptor() {
    	    			return Util.getImageDescriptor("icons/play.png");
    	    		}
    	    		public void run() {
    	    			dcpu.run();
    	    			treeViewer.refresh();
    	    		};
    	    	});
	 	    		manager.add(new Action("Clear RAM") {
	  	    		public void run() {
	  	    			for (int i = 0; i < 65536; i++) {
	  	    				dcpu.ram[i] = 0;
	  	    			}
	  	    			treeViewer.refresh();
	  	    		};
	  	    	});
		    		manager.add(new Action("Load from binary...") {
	        		public void run() {
	        			FileDialog fd = new FileDialog(container.getShell(), SWT.OPEN);
	              fd.setText("Load binary file (big endian)");
	              String selected = fd.open();
	              if (selected != null) {
										try {
											dcpu.load(new File(selected));
										} catch (IOException e) {
											e.printStackTrace();
										}
	              }
	        			treeViewer.refresh();
	        		};
						});
	    		}
	    		manager.add(new Action("Dump RAM to file...") {
        		public void run() {
        			FileDialog fd = new FileDialog(container.getShell(), SWT.SAVE);
              fd.setText("Save binary file (big endian)");
              String selected = fd.open();
              if (selected != null) {
              	try {
									dcpu.save(new File(selected));
								} catch (IOException e) {
									e.printStackTrace();
								}
              }
        			treeViewer.refresh();
        		};
					});
	    		
	    		manager.add(new Action("Connect hardware...") {
	    			@Override
  	    		public ImageDescriptor getImageDescriptor() {
  	    			return Util.getImageDescriptor("icons/hw.png");
  	    		}
  	    		public void run() {
        			ListSelectionDialog listDialog = new ListSelectionDialog(container.getShell(), Activator.getShip().getHardwareManager(), contentProvider, labelProvider, "Choose hardware to connect to "+dcpu.getID()+".");
							listDialog.setTitle("Connect Hardware");
							int open = listDialog.open();
							if (open == ListSelectionDialog.OK) {
								Object[] res = listDialog.getResult();
								for (Object o : res) {
									if (o instanceof DCPUHardware) {
										((DCPUHardware) o).connectTo(dcpu);
									}
								}
							}
							treeViewer.refresh();
        		}
	    		});
        } else if (o instanceof VirtualFloppyDrive) {
        	final VirtualFloppyDrive vfd = (VirtualFloppyDrive) o;
        	if (vfd.getDisk() == null) {
        		final ArrayList<FloppyDisk> disks = Activator.getShip().getFloppyManager().getAvailableDisks();
        		if (disks.size() > 0)
        		{
	        		MenuManager attachMenu = new MenuManager("Insert Floppy",Util.getImageDescriptor("icons/disk.png"),null);
		      	  attachMenu.addMenuListener(new IMenuListener() {
		      	    @Override
		      	    public void menuAboutToShow(IMenuManager manager) {
		      	    	for (final FloppyDisk fd : disks)
		      	    	{
		      	    		manager.add(new Action(fd.getID()) {
		      	    			@Override
		        	    		public ImageDescriptor getImageDescriptor() {
		      	    				if (fd.isWriteProtected()) {
		      	    					return Util.getImageDescriptor("icons/protecteddisk.png");
		      	    				} else {
		      	    					return Util.getImageDescriptor("icons/disk.png");
		      	    				}
		        	    		}
		        	    		public void run() {
		        	    			vfd.insert(fd);
		        	    			treeViewer.refresh();
		        	    		};
		        	    	});
		      	    	}
		      	    }
		      	  });
		      	  attachMenu.setRemoveAllWhenShown(true);
		      	  menuMgr.add(attachMenu);
        		}  
        	} else {
        		menuMgr.add(new Action("Eject " + vfd.getDisk().getID()) {
        			@Override
    	    		public ImageDescriptor getImageDescriptor() {
        				if (vfd.getDisk().isWriteProtected()) {
        					return Util.getImageDescriptor("icons/protecteddisk.png");
        				} else {
        					return Util.getImageDescriptor("icons/disk.png");
        				}
    	    		}
    	    		public void run() {
    	    			vfd.eject();
    	    			treeViewer.refresh();
    	    		};
    	    	});
        	}
        }
	      }
	    }
	  });
	  menuMgr.setRemoveAllWhenShown(true);
	  treeViewer.getControl().setMenu(menu);
	  getSite().registerContextMenu(menuMgr,treeViewer);
	  
	  treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent e) {
				if (e.getSelection() instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection)e.getSelection()).getFirstElement();
					if (o instanceof DefaultControllableDCPU) {
						DefaultControllableDCPU dcpu = (DefaultControllableDCPU) o;
						MappedView<DefaultControllableDCPU> view = ViewMapper.getFirstView(dcpu);
						if (view == null) {
							try {
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(ViewMapper.createMappedView(dcpu, DCPUView.ID));
							} catch (Exception e1) {
								e1.printStackTrace();
							}	
						} else {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(view);
						}
					} else if (o instanceof VirtualMonitor) {
						VirtualMonitor vm = (VirtualMonitor) o;
						MappedView<VirtualMonitor> view = ViewMapper.getFirstView(vm);
						if (view == null) {
							try {
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(ViewMapper.createMappedView(vm, LEM1802View.ID));
							} catch (Exception e1) {
								e1.printStackTrace();
							}	
						} else {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(view);
						}
					} else if (o instanceof VirtualKeyboard) {
						VirtualKeyboard vk = (VirtualKeyboard) o;
						MappedView<VirtualKeyboard> view = ViewMapper.getFirstView(vk);
						if (view == null) {
							try {
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(
										ViewMapper.createMappedView(vk, KeyboardView.ID));
							} catch (Exception e1) {
								e1.printStackTrace();
							}	
						} else {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(view);
						}
					} else if (o instanceof VirtualVectorDisplay) {
						VirtualVectorDisplay vvd = (VirtualVectorDisplay) o;
						MappedView<VirtualVectorDisplay> view = ViewMapper.getFirstView(vvd);
						if (view == null) {
							//TODO Add special handling for SPED-3's Single-instance limitation.
							try {
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(
										ViewMapper.createMappedView(vvd, SPED3View.ID));
							} catch (Exception e1) {
								e1.printStackTrace();
							}	
						} else {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(view);
						}
					}
				}
			}
		});
	}

	public void setFocus() {
	}
}