package devcpu.emulation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;

import devcpu.util.IntHashMap;

public class OpCodes
{
  private HashMap<String, OpCode> codes = new HashMap<String, OpCode>();
  private IntHashMap<OpCode> ids = new IntHashMap<OpCode>();

  public static final OpCodes basic = new OpCodes(BasicOp.class);
  public static final OpCodes special = new OpCodes(SpecialOp.class);

  private OpCodes(Class<?> c)
  {
    System.out.println("Start " + c);
    for (Field f : c.getFields())
      try {
        OpCode opCode = new OpCode(f.getName(), f.getInt(null));
        this.codes.put(opCode.name.toUpperCase(), opCode);
        ids.put(opCode.value, opCode);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public boolean contains(String name) {
    return this.codes.containsKey(name.toUpperCase());
  }
  
  public Set<String> getNames() {
  	return codes.keySet();
  }

  public int getId(String name) {
    return ((OpCode)this.codes.get(name.toUpperCase())).value;
  }

  public String getName(int id) {
    return ((OpCode)ids.get(id)).name;
  }

  private static class OpCode
  {
    public final String name;
    public final int value;

    public OpCode(String name, int value)
    {
      this.name = name;
      this.value = value;
    }
  }
}