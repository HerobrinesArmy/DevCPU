package com.mojang.spacegame;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class MemoryTracker
{
  private static List<Integer> lists = new ArrayList();
  private static List<Integer> textures = new ArrayList();

  public static synchronized int genLists(int count)
  {
    int id = GL11.glGenLists(count);
    lists.add(Integer.valueOf(id));
    lists.add(Integer.valueOf(count));

    return id;
  }

  public static synchronized void genTextures(IntBuffer ib) {
    GL11.glGenTextures(ib);
    for (int i = ib.position(); i < ib.limit(); i++)
      textures.add(Integer.valueOf(ib.get(i)));
  }

  public static synchronized void release(int pos)
  {
    int i = lists.indexOf(Integer.valueOf(pos));
    GL11.glDeleteLists(((Integer)lists.get(i)).intValue(), ((Integer)lists.get(i + 1)).intValue());
    lists.remove(i);
    lists.remove(i);
  }

  public static synchronized void release() {
    for (int i = 0; i < lists.size(); i += 2) {
      GL11.glDeleteLists(((Integer)lists.get(i)).intValue(), ((Integer)lists.get(i + 1)).intValue());
    }
    IntBuffer ib = createIntBuffer(textures.size());
    ib.flip();
    GL11.glDeleteTextures(ib);
    for (int i = 0; i < textures.size(); i++) {
      ib.put(((Integer)textures.get(i)).intValue());
    }
    ib.flip();
    GL11.glDeleteTextures(ib);
    lists.clear();
    textures.clear();
  }

  public static synchronized ByteBuffer createByteBuffer(int size)
  {
    ByteBuffer bb = ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());

    return bb;
  }

  public static ShortBuffer createShortBuffer(int size) {
    return createByteBuffer(size << 1).asShortBuffer();
  }

  public static CharBuffer createCharBuffer(int size) {
    return createByteBuffer(size << 1).asCharBuffer();
  }

  public static IntBuffer createIntBuffer(int size) {
    return createByteBuffer(size << 2).asIntBuffer();
  }

  public static LongBuffer createLongBuffer(int size) {
    return createByteBuffer(size << 3).asLongBuffer();
  }

  public static FloatBuffer createFloatBuffer(int size) {
    return createByteBuffer(size << 2).asFloatBuffer();
  }

  public static DoubleBuffer createDoubleBuffer(int size) {
    return createByteBuffer(size << 3).asDoubleBuffer();
  }
}