package com.mojang.spacegame;

import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JFrame;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import util.GLX;

import com.mojang.spacegame.renderer.Tesselator;
import com.mojang.spacegame.renderer.Textures;

import devcpu.emulation.AWTKeyMapping;
import devcpu.emulation.DCPU;
import devcpu.emulation.VirtualClock;
import devcpu.emulation.VirtualFloppyDrive;
import devcpu.emulation.VirtualKeyboard;
import devcpu.emulation.VirtualMonitor;
import devcpu.emulation.VirtualSleepChamber;
import devcpu.emulation.VirtualVectorDisplay;
public class SpaceGame
  implements Runnable
{
  public static final String GAME_NAME = "SpaceGame";
  public static final String GAME_VERSION = "prototype";
  public static SpaceGame game;
  private int lists;
  private Shader shadowVolumeShader;
  private Shader lightShader;
  private Shader depthShader;
  private Shader fourLight;
  private Shader displayShader;
  private int[] noiseTexture = new int[32];
  private int cubeMap;
  private DCPU cpu = new DCPU();
  private VirtualMonitor vmonitor = (VirtualMonitor) new VirtualMonitor().connectTo(cpu);//this.cpu.ram, 32768);
  private VirtualKeyboard vkeyboard = (VirtualKeyboard) new VirtualKeyboard(new AWTKeyMapping()).connectTo(cpu);//this.cpu.ram, 36864, new AWTKeyMapping());
  public VirtualFloppyDrive vfloppydrive = (VirtualFloppyDrive) new VirtualFloppyDrive().connectTo(cpu);
  {
  	new VirtualClock().connectTo(cpu);
  	new VirtualSleepChamber().connectTo(cpu);
  	new VirtualVectorDisplay().connectTo(cpu);
  }
  private int monitorTexture = 0;

  float time = 0.0F;
  private float yRot;
  private float xRot;
  private float xCam;
  private float yCam;
  private float zCam;
  private long start;

  public SpaceGame(String memoryPath) 
  {
	  game = this;
	  DataInputStream dis = null;
      try {
    	  dis = new DataInputStream(new FileInputStream(memoryPath));
        for (int i = 0; ; i++) {
          char ch = dis.readChar();
          cpu.ram[i] = ch;
        }
      }
      catch (Exception e) {
    	  try {
			dis.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
      }
  }

public SpaceGame(InputStream memoryStream) 
{
	game = this;
	DataInputStream dis = null;
    try {
  	  dis = new DataInputStream(memoryStream);
      for (int i = 0; ; i++) {
        char ch = dis.readChar();
        cpu.ram[i] = ch;
      }
    }
    catch (Exception e) {
  	  try {
			dis.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
}

public void init() throws Exception {
	//new Assembler(this.cpu.ram).assemble("os.asm");

//    Display.setResizable(true);
//    Display.setDisplayMode(new org.lwjgl.opengl.DisplayMode(w, h));
//    Display.setLocation(x, y);
//    Display.setTitle("SpaceGame [prototype]");
//    Display.setIcon(new ByteBuffer[] { loadIcon(getClass().getResource("/icon16.png")), loadIcon(getClass().getResource("/icon32.png")) });
//    Display.create(new PixelFormat().withDepthBits(24).withBitsPerPixel(32).withStencilBits(8));

//    Keyboard.create();
//    Mouse.create();
    AWTMouse.setGrabbed(true);
    
    Controllers.create();
    int controllerCount = Controllers.getControllerCount();
    System.out.println("controllers: " + controllerCount);
    for (int i = 0; i < controllerCount; i++) {
      Controller c = Controllers.getController(i);
      System.out.println("Controller " + i + ": " + c.getName());
      System.out.println("Axis: " + c.getAxisCount());
      for (int j = 0; j < c.getAxisCount(); j++) {
        System.out.println("   Axis " + j + ": " + c.getAxisName(j));
      }
      System.out.println("Buttons: " + c.getButtonCount());
      for (int j = 0; j < c.getButtonCount(); j++) {
        System.out.println("   Button " + j + ": " + c.getButtonName(j));
      }
    }

    GL11.glShadeModel(7425);

    this.lightShader = new Shader("test");
    this.depthShader = new Shader("depth");
    this.fourLight = new Shader("4light");
    new Shader("dist");

    this.shadowVolumeShader = new Shader("shadowVolume");
    this.displayShader = new Shader("display");

    for (int j = 0; j < 32; j++) {
      Random random = new Random();
      BufferedImage noise = new BufferedImage(256, 256, 2);
      int[] pixels = new int[65536];
      for (int i = 0; i < pixels.length; i++) {
        pixels[i] = random.nextInt();
      }
      noise.setRGB(0, 0, 256, 256, pixels, 0, 256);

      this.noiseTexture[j] = Textures.instance.getTexture(noise);
    }

    this.lists = GL11.glGenLists(2);
    GL11.glNewList(this.lists, 4864);
    renderScene();
    GL11.glEndList();
    GL11.glNewList(this.lists + 1, 4864);
    renderShadows();
    GL11.glEndList();

    this.cubeMap = Textures.instance.generateCubeMap();
    this.monitorTexture = Textures.instance.getTexture(new BufferedImage(128, 128, 2));

    this.xCam = 5.1F;
    this.zCam = 7.3F;
    this.yRot = 10.0F;
    this.xRot = -50.0F;
    start = System.nanoTime();
  }

  public void renderScene()
  {
    renderMonitor(false);

    renderRoom(0.0D, 0.0D, 0.0D, 8.0D, 3.0D, 8.0D);
    float s = 0.2F;

    Random random = new Random(1000L);
    for (int i = 0; i < 10; i++) {
      GL11.glPushMatrix();
      float x = (float)(random.nextDouble() - 0.5D) * 4.0F + 4.0F;
      float y = (float)random.nextDouble() * 2.5F;
      float z = (float)(random.nextDouble() - 0.5D) * 4.0F + 4.0F;
      GL11.glTranslatef(x, y, z);
      GL11.glRotatef(-this.time * 360.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
      box(-s, -s, -s, s, s, s);
      GL11.glPopMatrix();
    }
  }

  public void renderShadows() {
    renderMonitorShadow();

    renderShadowRoom(0.0D, 0.0D, 0.0D, 8.0D, 3.0D, 8.0D);

    float s = 0.2F;
    Random random = new Random(1000L);
    for (int i = 0; i < 10; i++) {
      GL11.glPushMatrix();
      float x = (float)(random.nextDouble() - 0.5D) * 4.0F + 4.0F;
      float y = (float)random.nextDouble() * 2.5F;
      float z = (float)(random.nextDouble() - 0.5D) * 4.0F + 4.0F;
      GL11.glTranslatef(x, y, z);
      GL11.glRotatef(-this.time * 360.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
      shadowBox(-s, -s, -s, s, s, s);
      GL11.glPopMatrix();
    }
  }

  private void renderShadowRoom(double x0, double y0, double z0, double x1, double y1, double z1) {
    double t = 0.2000000029802322D;
    shadowBox(x0 - t, y0, z0, x0, y1, z1);
    shadowBox(x1, y0, z0, x1 + t, y1, z1);

    shadowBox(x0 - t, y0 - t, z0 - t, x1 + t, y0, z1 + t);
    shadowBox(x0 - t, y1, z0 - t, x1 + t, y1 + t, z1 + t);

    double xm = (x0 + x1) / 2.0D;
    double ym = (y0 + y1) / 2.0D;

    shadowBox(x0, y0, z0 - t, xm - 2.0D, y1, z0);
    shadowBox(xm + 2.0D, y0, z0 - t, x1, y1, z0);
    shadowBox(xm - 2.0D, y0, z0 - t, xm + 2.0D, ym - 1.0D, z0);
    shadowBox(xm - 2.0D, ym + 1.0D, z0 - t, xm + 2.0D, y1, z0);
    shadowBox(x0, y0, z1, x1, y1, z1 + t);
  }

  private void renderRoom(double x0, double y0, double z0, double x1, double y1, double z1) {
    double t = 0.2000000029802322D;
    box(x0 - t, y0, z0, x0, y1, z1);
    box(x1, y0, z0, x1 + t, y1, z1);

    box(x0 - t, y0 - t, z0 - t, x1 + t, y0, z1 + t);
    box(x0 - t, y1, z0 - t, x1 + t, y1 + t, z1 + t);

    double xm = (x0 + x1) / 2.0D;
    double ym = (y0 + y1) / 2.0D;

    box(x0, y0, z0 - t, xm - 2.0D, y1, z0);
    box(xm + 2.0D, y0, z0 - t, x1, y1, z0);
    box(xm - 2.0D, y0, z0 - t, xm + 2.0D, ym - 1.0D, z0);
    box(xm - 2.0D, ym + 1.0D, z0 - t, xm + 2.0D, y1, z0);
    box(x0, y0, z1, x1, y1, z1 + t);
  }

  public void renderMonitorShadow()
  {
//    if (this != null) return;
    double x = 0.0D;
    double y = 1.32D;
    double z = 3.9D;

    double scale = 2.0D;
    double th = 0.01D * scale;
    double w = 0.5D * scale;
    double h = 0.375D * scale;
    double d = 0.05D * scale;

    GL11.glPushMatrix();
    GL11.glTranslatef((float)x, (float)y, (float)z);
    GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
    GL11.glTranslatef((float)(-w / 2.0D), 0.0F, (float)(-d));
    shadowBox(0.0D, 0.0D, d - th, w, h, d);
    shadowBox(-th, 0.0D, 0.0D, 0.0D, h, d);
    shadowBox(w, 0.0D, 0.0D, w + th, h, d);
    shadowBox(-th, -th, 0.0D, w + th, 0.0D, d);
    shadowBox(-th, h, 0.0D, w + th, h + th, d);
    GL11.glPopMatrix();
  }

  public void renderMonitor(boolean display) {
    double x = 0.0D;
    double y = 1.32D;
    double z = 3.9D;

    double scale = 2.0D;
    double th = 0.01D * scale;
    double w = 0.5D * scale;
    double h = 0.375D * scale;
    double d = 0.05D * scale;
    GL11.glPushMatrix();
    GL11.glTranslatef((float)x, (float)y, (float)z);
    GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
    GL11.glTranslatef((float)(-w / 2.0D), 0.0F, (float)(-d));

    if (display) {
      double zz = 0.015D;
      Tesselator t = Tesselator.instance;
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      t.begin(7);
      t.color(2105376, 240);
      t.vertexUV(0.0D, h, zz, 1.0D, 0.0D);
      t.vertexUV(w, h, zz, 0.0D, 0.0D);
      t.vertexUV(w, 0.0D, zz, 0.0D, 0.75D);
      t.vertexUV(0.0D, 0.0D, zz, 1.0D, 0.75D);
      t.end();

      GL11.glEnable(3553);
      this.vmonitor.render();
      Textures.instance.replaceTexture(this.vmonitor.pixels, 128, 128, this.monitorTexture);
      GL11.glBindTexture(3553, this.monitorTexture);

      this.displayShader.enable();
      GL11.glBlendFunc(1, 1);
      zz = 0.012D;
      int b = 6;
      t.begin(7);
      t.color(16777215);
      t.vertexUV(0.0D, h, zz, (255 + b) / 128.0D, (127 - b) / 128.0D);
      t.vertexUV(w, h, zz, (127 - b) / 128.0D, (127 - b) / 128.0D);
      t.vertexUV(w, 0.0D, zz, (127 - b) / 128.0D, (223.0D + b) / 128.0D);
      t.vertexUV(0.0D, 0.0D, zz, (255 + b) / 128.0D, (223.0D + b) / 128.0D);
      t.end();
      GL11.glDisable(3553);
      GL11.glDisable(3042);
      this.displayShader.disable();
    } else {
      box(0.0D, 0.0D, d - th, w, h, d);
      box(-th, 0.0D, 0.0D, 0.0D, h, d);
      box(w, 0.0D, 0.0D, w + th, h, d);
      box(-th, -th, 0.0D, w + th, 0.0D, d);
      box(-th, h, 0.0D, w + th, h + th, d);
    }

    GL11.glPopMatrix();
  }

  public void gameLoop()
    throws LWJGLException
  {
	long elapsed = System.nanoTime()-start;
	start += elapsed;
	while (cpu.cycles <  (((double)elapsed)/10000.0D))
	  this.cpu.tick();
	cpu.tickHardware();
	cpu.cycles -=  (((double)elapsed)/10000.0D);
    GL11.glBindTexture(34067, this.cubeMap);
    this.time = ((float)(System.currentTimeMillis() % 10000L) / 10000.0F);
    int lights = 1;

    if (AWTMouse.isGrabbed())
    {
      this.xRot += AWTMouse.getDX() * 0.1F;
      this.yRot -= AWTMouse.getDY() * 0.1F;
      if (this.yRot < -90.0F) this.yRot = -90.0F;
      if (this.yRot > 90.0F) this.yRot = 90.0F;

      double xa = 0.0D;
      double ya = 0.0D;
      if (AWTKeyboard.isKeyDown(17+70)) ya += 2.5D;//1.0D;
      if (AWTKeyboard.isKeyDown(30+35)) xa -= 2.5D;//1.0D;
      if (AWTKeyboard.isKeyDown(31+52)) ya -= 2.5D;//1.0D;
      if (AWTKeyboard.isKeyDown(32+36)) xa += 2.5D;//1.0D;

      this.yCam = 1.7F;
      double rott = this.xRot * 3.141592653589793D * 2.0D / 360.0D;
      double c = Math.cos(rott);
      double s = Math.sin(rott);
      double speed = 0.01D;
      this.zCam = (float)(this.zCam + (s * xa - c * ya) * speed);
      this.xCam = (float)(this.xCam + (c * xa + s * ya) * speed);
    }

    float r = 0.0F;
    float g = 0.0F;
    float b = 0.0F;

    GL11.glClearColor(r, g, b, 1.0F);
    GL11.glClear(17664);
    int w = GameFrame.canvas.getWidth();
    int h = GameFrame.canvas.getHeight();
    if ((w < 256) || (h < 256)) {
      if (w < 256) w = 256;
      if (h < 256) h = 256; try
      {
//        Display.setResizable(false);
//        Display.setDisplayMode(new org.lwjgl.opengl.DisplayMode(w, h));
//        Display.setResizable(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    float aspect = (float)w / (float)h;
    float rot = (float)(this.time * 3.141592653589793D * 2.0D);

    GL11.glEnable(2929);
    GL11.glEnable(2884);
    GL11.glDepthFunc(515);
    GL11.glShadeModel(7425);

    GL11.glCullFace(1029);

    GL11.glViewport(0, 0, w, h);
    GL11.glClear(16640);
    GL11.glMatrixMode(5889);
    GL11.glLoadIdentity();
    
    GLU.gluPerspective(70.0F, aspect, 0.1F, 40.0F);
    GL11.glMatrixMode(5888);
    GL11.glLoadIdentity();

    GL11.glRotatef(this.yRot, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(this.xRot, 0.0F, 1.0F, 0.0F);
    GL11.glTranslatef(-this.xCam, -this.yCam, -this.zCam);

    GL11.glDisable(3042);
    this.depthShader.enable();
    renderScene();

    GL11.glDepthMask(false);
    GL11.glEnable(3042);
    GL11.glBlendFunc(1, 1);

    Random random = new Random(600L);
    for (int i = 0; i <= lights; i++) {
      GL11.glBindTexture(3553, this.noiseTexture[(i % this.noiseTexture.length)]);

      for (int j = 0; j < 1; j++) {
        float dist = random.nextFloat() * 4.0F;
        float xx = (float)Math.sin(rot + i / lights * 3.141592653589793D * 2.0D) * dist + 4.0F;
        float yy = random.nextFloat() * 2.8F + 0.1F;
        float zz = (float)Math.cos(rot + i / lights * 3.141592653589793D * 2.0D) * dist + 4.0F;

        float rr = (float)(Math.sin((i / lights + 0.0D) * 3.141592653589793D * 2.0D) * 0.05D + 0.55D);
        float gg = (float)(Math.sin((i / lights + 0.3333333333333333D) * 3.141592653589793D * 2.0D) * 0.05D + 0.55D);
        float bb = (float)(Math.sin((i / lights + 0.6666666666666666D) * 3.141592653589793D * 2.0D) * 0.05D + 0.55D);

        GL11.glLightf(16384 + j, 4617, 0.2F);

        if (i == lights) {
          xx = 0.3F;
          yy = 1.7F;
          zz = 3.95F;
          rr = 0.2f + 2f*((vmonitor.getLightColor() & 0xFF0000)>>16)/255F;
          gg = 0.2f + 2f*((vmonitor.getLightColor() & 0xFF00)>>8)/255F;
          bb = 0.2f + 2f*(vmonitor.getLightColor() & 0xFF)/255F;
          GL11.glLightf(16384 + j, 4617, 2.0F);
        } else {
          rr = gg = bb = 0.0F;
        }

        GL11.glLight(16384 + j, 4611, GLX.getf(xx, yy, zz, 1.0F));
        GL11.glLight(16384 + j, 4609, GLX.getf(rr, gg, bb, 1.0F));
        GL11.glLight(16384 + j, 4608, GLX.getf(0.0F, 0.0F, 0.0F, 1.0F));
        GL11.glLight(16384 + j, 4610, GLX.getf(0.0F, 0.0F, 0.0F, 1.0F));

        GL11.glLightf(16384 + j, 4615, 0.0F);
      }

      GL11.glClear(1024);
      GL11.glEnable(2960);
      this.shadowVolumeShader.enable();
      GL11.glColorMask(false, false, false, false);
      GL11.glDepthFunc(513);
      GL11.glCullFace(1028);
      GL11.glStencilFunc(519, 0, 255);
      GL11.glStencilOp(7680, 7682, 7680);
      renderShadows();

      GL11.glCullFace(1029);
      GL11.glStencilFunc(519, 0, 255);
      GL11.glStencilOp(7680, 7683, 7680);
      renderShadows();

      GL11.glStencilFunc(514, 0, 255);
      GL11.glStencilOp(7680, 7680, 7680);

      GL11.glCullFace(1029);

      GL11.glDepthFunc(515);
      this.fourLight.enable();
      GL11.glColorMask(true, true, true, true);
      renderScene();
    }

    this.lightShader.disable();
    GL11.glDisable(2896);
    GL11.glDisable(2960);
    GL11.glDepthMask(true);

    GL11.glDisable(3042);
    renderMonitor(true);

    GL11.glDisable(2884);

//    Display.update();

//    if (Display.isCloseRequested())
//      stop();
  }

  private void box(double x0, double y0, double z0, double x1, double y1, double z1) {
    Tesselator t = Tesselator.instance;
    t.begin(7);

    quad(x0, y0, z0, x1, y0, z0, x1, y0, z1, x0, y0, z1);

    quad(x0, y1, z1, x1, y1, z1, x1, y1, z0, x0, y1, z0);

    quad(x1, y1, z0, x1, y1, z1, x1, y0, z1, x1, y0, z0);

    quad(x0, y1, z1, x0, y1, z0, x0, y0, z0, x0, y0, z1);

    quad(x0, y0, z1, x1, y0, z1, x1, y1, z1, x0, y1, z1);

    quad(x0, y1, z0, x1, y1, z0, x1, y0, z0, x0, y0, z0);
    t.end();
  }

  private void shadowBox(double x0, double y0, double z0, double x1, double y1, double z1) {
    Tesselator t = Tesselator.instance;
    t.begin(7);

    shadowQuad(x0, y0, z0, x1, y0, z0, x1, y0, z1, x0, y0, z1);

    shadowQuad(x0, y1, z1, x1, y1, z1, x1, y1, z0, x0, y1, z0);

    shadowQuad(x1, y1, z0, x1, y1, z1, x1, y0, z1, x1, y0, z0);

    shadowQuad(x0, y1, z1, x0, y1, z0, x0, y0, z0, x0, y0, z1);

    shadowQuad(x0, y0, z1, x1, y0, z1, x1, y1, z1, x0, y1, z1);

    shadowQuad(x0, y1, z0, x1, y1, z0, x1, y0, z0, x0, y0, z0);
    t.end();
  }

  private void quad(double x0, double y0, double z0, double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3) {
    Tesselator t = Tesselator.instance;

    double Ux = x1 - x0;
    double Uy = y1 - y0;
    double Uz = z1 - z0;
    double Vx = x3 - x0;
    double Vy = y3 - y0;
    double Vz = z3 - z0;

    double Nx = Uy * Vz - Uz * Vy;
    double Ny = Uz * Vx - Ux * Vz;
    double Nz = Ux * Vy - Uy * Vx;
    double dist = Math.sqrt(Nx * Nx + Ny * Ny + Nz * Nz);
    Nx /= dist;
    Ny /= dist;
    Nz /= dist;

    t.normal((float)Nx, (float)Ny, (float)Nz);

    t.vertex(x0, y0, z0);
    t.vertex(x1, y1, z1);
    t.vertex(x2, y2, z2);
    t.vertex(x3, y3, z3);
  }

  private void shadowQuad(double x0, double y0, double z0, double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3)
  {
    Tesselator t = Tesselator.instance;

    double Ux = x1 - x0;
    double Uy = y1 - y0;
    double Uz = z1 - z0;

    double Vx = x3 - x0;
    double Vy = y3 - y0;
    double Vz = z3 - z0;

    double Nx = Uy * Vz - Uz * Vy;
    double Ny = Uz * Vx - Ux * Vz;
    double Nz = Ux * Vy - Uy * Vx;
    double dist = Math.sqrt(Nx * Nx + Ny * Ny + Nz * Nz);
    Nx /= dist;
    Ny /= dist;
    Nz /= dist;

    t.normal((float)Nx, (float)Ny, (float)Nz);

    t.color(0);
    t.vertex(x0, y0, z0);
    t.vertex(x1, y1, z1);
    t.vertex(x2, y2, z2);
    t.vertex(x3, y3, z3);

    t.color(16711680);
    t.vertex(x3, y3, z3);
    t.vertex(x2, y2, z2);
    t.vertex(x1, y1, z1);
    t.vertex(x0, y0, z0);

    t.color(16711680);
    t.vertex(x0, y0, z0);
    t.vertex(x1, y1, z1);
    t.color(0);
    t.vertex(x1, y1, z1);
    t.vertex(x0, y0, z0);

    t.color(16711680);
    t.vertex(x1, y1, z1);
    t.vertex(x2, y2, z2);
    t.color(0);
    t.vertex(x2, y2, z2);
    t.vertex(x1, y1, z1);

    t.color(16711680);
    t.vertex(x2, y2, z2);
    t.vertex(x3, y3, z3);
    t.color(0);
    t.vertex(x3, y3, z3);
    t.vertex(x2, y2, z2);

    t.color(16711680);
    t.vertex(x3, y3, z3);
    t.vertex(x0, y0, z0);
    t.color(0);
    t.vertex(x0, y0, z0);
    t.vertex(x3, y3, z3);
  }

  public void run() {
//    try {
//      init();
//    } catch (Exception e) {
//      crash("Initialization", e);
//      return;
//    }
//    try
//    {
//      long lastFrameTime = System.currentTimeMillis();
//      int frames = 0;
//
//      while (!this.stop) {
//        gameLoop();
//        frames++;
//
//        long now = System.currentTimeMillis();
//        if (now - lastFrameTime > 1000L) {
//          lastFrameTime += 1000L;
//          System.out.println(frames + " fps");
//          frames = 0;
//        }
//      }
//    } catch (Exception e) {
//      crash("Runtime", e);
//      return;
//    }
  }

	public VirtualKeyboard getVirtualKeyboard() {
		return vkeyboard;		
	}
	
	public static void main(String[] args) {
		SpaceGame game = null;
		if (args.length > 0)
		{
			game = new SpaceGame(args[0]);
		}
		else
		{
			game = new SpaceGame(SpaceGame.class.getResourceAsStream("/devcpu/emulation/testdump.dmp"));
		}
		try {
			new GameFrame(game);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
}

class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static GameCanvas canvas;

	public GameFrame(SpaceGame game) throws LWJGLException {
	setTitle("0x10c Prototype with updated DCPU - Merged by Herobrine");
	setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().width* 8 / 10F), (int)(Toolkit.getDefaultToolkit().getScreenSize().height* 8 / 10F));
	setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().width* 1 / 10F), (int)(Toolkit.getDefaultToolkit().getScreenSize().height* 1 / 10F));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	canvas = new GameCanvas(game);
	add(canvas);
	setVisible(true);
	canvas.addMouseListener(AWTMouse.mouse);
	canvas.addMouseMotionListener(AWTMouse.mouse);
	canvas.addFocusListener(AWTMouse.mouse);
	canvas.addKeyListener(AWTKeyboard.keyboard);
	canvas.requestFocus();
	new Thread(){public void run(){for(;;){canvas.repaint();}}}.start();
	}

	public class GameCanvas extends AWTGLCanvas { 
		private static final long serialVersionUID = 1L;
		private SpaceGame game;

		public GameCanvas(final SpaceGame game) throws LWJGLException {
			super();
			this.game = game;
			addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == 'i') {
//						game.vfloppydrive.insert(new FloppyDisk());
					} else if (e.getKeyChar() == 'e') {
						game.vfloppydrive.eject();
					}
				}
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}

		@Override
		protected void initGL() {
			super.initGL();
			try {
				game.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void paintGL() {
			try {
				makeCurrent();
				game.gameLoop();
				swapBuffers();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}
		}
	}

class AWTKeyboard implements KeyListener {
	public static final AWTKeyboard keyboard = new AWTKeyboard();
	HashSet<Integer> buttonsDown = new HashSet<Integer>();
	
	public static boolean isKeyDown(int i) {
		return keyboard.buttonsDown.contains(i);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		buttonsDown.add(e.getKeyCode());
		SpaceGame.game.getVirtualKeyboard().keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		buttonsDown.remove(e.getKeyCode());
		SpaceGame.game.getVirtualKeyboard().keyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		SpaceGame.game.getVirtualKeyboard().keyTyped(e.getKeyChar());		
	}
}

class AWTMouse implements MouseListener, MouseMotionListener, FocusListener {
	public static final AWTMouse mouse = new AWTMouse();
	private boolean grabbed;
	private int lastX;
	private int thisX;
	private int lastY;
	private int thisY;

	public static boolean isGrabbed() {
		return mouse.grabbed;
	}

	public static void setGrabbed(boolean grabbed) {
		mouse.grabbed = grabbed;
		if (grabbed)
		{
			mouse.thisX = mouse.lastX;
			mouse.thisY = mouse.lastY;
		}
	}

	public static float getDX() {
		float d = mouse.thisX-mouse.lastX;
		mouse.lastX = mouse.thisX;
		return d;
	}

	public static float getDY() {
		float d = mouse.thisY-mouse.lastY;
		mouse.lastY = mouse.thisY;
		return -d;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		grabbed = true;
		thisX = lastX = e.getX();
		thisY = lastY = e.getY();
	}
	
	@Override 
	public void mouseEntered(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (grabbed)
		{
			thisX = e.getX();
			thisY = e.getY();
		}
		else
		{
			lastX = e.getX();
			lastY = e.getY();
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		grabbed = false;
	}
	
	@Override public void mouseExited(MouseEvent e){}
	@Override public void mousePressed(MouseEvent e){}
	@Override public void mouseReleased(MouseEvent e){}
	@Override public void mouseDragged(MouseEvent e){}
	@Override public void focusGained(FocusEvent e){}
}