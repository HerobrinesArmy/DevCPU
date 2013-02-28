package com.mojang.spacegame.renderer;

import com.mojang.spacegame.MemoryTracker;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;
import util.IntHashMap;

public class Textures
{
  public static final Textures instance = new Textures();

  public static boolean MIPMAP = false;

  private HashMap<String, Integer> idMap = new HashMap();
  private HashMap<String, int[]> pixelsMap = new HashMap();
  private IntHashMap<BufferedImage> loadedImages = new IntHashMap();
  private IntBuffer ib = MemoryTracker.createIntBuffer(1);
  private ByteBuffer pixels = MemoryTracker.createByteBuffer(16777216);

  public boolean clamp = false;
  public boolean blur = false;

  private BufferedImage missingNo = new BufferedImage(64, 64, 2);

  byte[] newPixels = new byte[1];

  private Textures()
  {
    Graphics localGraphics = this.missingNo.getGraphics();
    localGraphics.setColor(Color.WHITE);
    localGraphics.fillRect(0, 0, 64, 64);
    localGraphics.setColor(Color.BLACK);
    localGraphics.drawString("missingtex", 1, 10);

    localGraphics.dispose();
  }

  public int[] loadTexturePixels(String paramString) {
    Class<Textures> localTextures = Textures.class;

    int[] arrayOfInt1 = (int[])(int[])this.pixelsMap.get(paramString);
    if (arrayOfInt1 != null) return arrayOfInt1; int[] arrayOfInt2;
    try
    {
      arrayOfInt2 = (int[])null;
      InputStream localInputStream = localTextures.getResourceAsStream(paramString);
      if (localInputStream == null)
        arrayOfInt2 = loadTexturePixels(this.missingNo);
      else {
        arrayOfInt2 = loadTexturePixels(readImage(localInputStream));
      }

      this.pixelsMap.put(paramString, arrayOfInt2);
      return arrayOfInt2;
    } catch (IOException localIOException) {
      localIOException.printStackTrace();
      arrayOfInt2 = loadTexturePixels(this.missingNo);
      this.pixelsMap.put(paramString, arrayOfInt2);
    }return arrayOfInt2;
  }

  private int[] loadTexturePixels(BufferedImage paramBufferedImage)
  {
    int i = paramBufferedImage.getWidth();
    int j = paramBufferedImage.getHeight();
    int[] arrayOfInt = new int[i * j];
    paramBufferedImage.getRGB(0, 0, i, j, arrayOfInt, 0, i);
    return arrayOfInt;
  }

  private int[] loadTexturePixels(BufferedImage paramBufferedImage, int[] paramArrayOfInt) {
    int i = paramBufferedImage.getWidth();
    int j = paramBufferedImage.getHeight();
    paramBufferedImage.getRGB(0, 0, i, j, paramArrayOfInt, 0, i);
    return paramArrayOfInt;
  }

  public int loadTexture(String paramString) {
    Class<Textures> localTextures = Textures.class;

    Integer localInteger = (Integer)this.idMap.get(paramString);
    if (localInteger != null) return localInteger.intValue();

    try
    {
      this.ib.clear();
      MemoryTracker.genTextures(this.ib);
      localInteger = Integer.valueOf(this.ib.get(0));
      InputStream localInputStream = localTextures.getResourceAsStream(paramString);
      if (localInputStream == null)
        loadTexture(this.missingNo, localInteger.intValue());
      else {
        loadTexture(readImage(localInputStream), localInteger.intValue());
      }

      this.idMap.put(paramString, Integer.valueOf(localInteger.intValue()));
      return localInteger.intValue();
    } catch (Exception localException) {
      localException.printStackTrace();
      MemoryTracker.genTextures(this.ib);
      localInteger = Integer.valueOf(this.ib.get(0));
      loadTexture(this.missingNo, localInteger.intValue());
      this.idMap.put(paramString, Integer.valueOf(localInteger.intValue()));
    }return localInteger.intValue();
  }

  public int generateCubeMap()
  {
    this.ib.clear();
    MemoryTracker.genTextures(this.ib);

    int i = this.ib.get(0);
    Random localRandom = new Random();

    byte[] arrayOfByte = new byte[1048576];
    for (int j = 0; j < arrayOfByte.length / 4; j++) {
      int k = 255;
      int m = localRandom.nextInt(256);
      int n = localRandom.nextInt(256);
      int i1 = localRandom.nextInt(256);

      arrayOfByte[(j * 4 + 0)] = (byte)m;
      arrayOfByte[(j * 4 + 1)] = (byte)n;
      arrayOfByte[(j * 4 + 2)] = (byte)i1;
      arrayOfByte[(j * 4 + 3)] = (byte)k;
    }
    this.pixels.clear();
    this.pixels.put(arrayOfByte);
    this.pixels.position(0).limit(arrayOfByte.length);

    GL11.glBindTexture(34067, i);
    GL11.glTexImage2D(34069, 0, 6408, 512, 512, 0, 6408, 5121, this.pixels);
    GL11.glTexImage2D(34070, 0, 6408, 512, 512, 0, 6408, 5121, this.pixels);
    GL11.glTexImage2D(34071, 0, 6408, 512, 512, 0, 6408, 5121, this.pixels);
    GL11.glTexImage2D(34072, 0, 6408, 512, 512, 0, 6408, 5121, this.pixels);
    GL11.glTexImage2D(34073, 0, 6408, 512, 512, 0, 6408, 5121, this.pixels);
    GL11.glTexImage2D(34074, 0, 6408, 512, 512, 0, 6408, 5121, this.pixels);
    GL11.glTexParameteri(34067, 10241, 9728);
    GL11.glTexParameteri(34067, 10240, 9728);
    GL11.glTexParameteri(3553, 10242, 33069);
    GL11.glTexParameteri(3553, 10243, 33069);

    return i;
  }

  public int getTexture(BufferedImage paramBufferedImage) {
    this.ib.clear();
    MemoryTracker.genTextures(this.ib);
    int i = this.ib.get(0);
    loadTexture(paramBufferedImage, i);
    this.loadedImages.put(i, paramBufferedImage);
    return i;
  }

  public void loadTexture(BufferedImage paramBufferedImage, int paramInt) {
    GL11.glBindTexture(3553, paramInt);

    if (MIPMAP) {
      GL11.glTexParameteri(3553, 10241, 9986);
      GL11.glTexParameteri(3553, 10240, 9728);
    }
    else
    {
      GL11.glTexParameteri(3553, 10241, 9728);
      GL11.glTexParameteri(3553, 10240, 9728);
    }
    if (this.blur) {
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
    }

    if (this.clamp) {
      GL11.glTexParameteri(3553, 10242, 33071);
      GL11.glTexParameteri(3553, 10243, 33071);
    } else {
      GL11.glTexParameteri(3553, 10242, 10497);
      GL11.glTexParameteri(3553, 10243, 10497);
    }

    int i = paramBufferedImage.getWidth();
    int j = paramBufferedImage.getHeight();

    int[] arrayOfInt = new int[i * j];
    byte[] arrayOfByte = new byte[i * j * 4];
    paramBufferedImage.getRGB(0, 0, i, j, arrayOfInt, 0, i);
    int m;
    int n;
    int i1;
    int i2;
    for (int k = 0; k < arrayOfInt.length; k++) {
      m = arrayOfInt[k] >> 24 & 0xFF;
      n = arrayOfInt[k] >> 16 & 0xFF;
      i1 = arrayOfInt[k] >> 8 & 0xFF;
      i2 = arrayOfInt[k] & 0xFF;

      arrayOfByte[(k * 4 + 0)] = (byte)n;
      arrayOfByte[(k * 4 + 1)] = (byte)i1;
      arrayOfByte[(k * 4 + 2)] = (byte)i2;
      arrayOfByte[(k * 4 + 3)] = (byte)m;
    }
    this.pixels.clear();
    this.pixels.put(arrayOfByte);
    this.pixels.position(0).limit(arrayOfByte.length);

    GL11.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, this.pixels);
    int k;
	if (MIPMAP)
      for (k = 1; k <= 7; k++) {
        m = i >> k - 1;

        n = i >> k;
        i1 = j >> k;

        for (i2 = 0; i2 < n; i2++)
          for (int i3 = 0; i3 < i1; i3++) {
            int i4 = this.pixels.getInt((i2 * 2 + 0 + (i3 * 2 + 0) * m) * 4);
            int i5 = this.pixels.getInt((i2 * 2 + 1 + (i3 * 2 + 0) * m) * 4);
            int i6 = this.pixels.getInt((i2 * 2 + 1 + (i3 * 2 + 1) * m) * 4);
            int i7 = this.pixels.getInt((i2 * 2 + 0 + (i3 * 2 + 1) * m) * 4);
            int i8 = crispBlend(crispBlend(i4, i5), crispBlend(i6, i7));
            this.pixels.putInt((i2 + i3 * n) * 4, i8);
          }
        GL11.glTexImage2D(3553, k, 6408, n, i1, 0, 6408, 5121, this.pixels);
      }
  }

  public void replaceTexture(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    GL11.glBindTexture(3553, paramInt3);

    int i = 0;

    int j = paramInt1 * paramInt2 * 4;
    if (this.newPixels.length < j) this.newPixels = new byte[j];
    for (int k = 0; k < paramInt1 * paramInt2; k++) {
      int m = paramArrayOfInt[k] >> 24 & 0xFF;
      int n = paramArrayOfInt[k] >> 16 & 0xFF;
      int i1 = paramArrayOfInt[k] >> 8 & 0xFF;
      int i2 = paramArrayOfInt[k] & 0xFF;

      this.newPixels[(k * 4 + 0)] = (byte)n;
      this.newPixels[(k * 4 + 1)] = (byte)i1;
      this.newPixels[(k * 4 + 2)] = (byte)i2;
      this.newPixels[(k * 4 + 3)] = (byte)m;
    }
    this.pixels.clear();
    this.pixels.put(this.newPixels, 0, j);
    this.pixels.position(0).limit(paramArrayOfInt.length * 4);

    GL11.glTexSubImage2D(3553, i, 0, 0, paramInt1, paramInt2, 6408, 5121, this.pixels);
  }

  public void releaseTexture(int paramInt)
  {
    this.loadedImages.remove(paramInt);
    this.ib.clear();
    this.ib.put(paramInt);
    this.ib.flip();
    GL11.glDeleteTextures(this.ib);
  }

  public void tick()
  {
    int i = -1;
  }

  private int crispBlend(int paramInt1, int paramInt2)
  {
    int i = (paramInt1 & 0xFF000000) >> 24 & 0xFF;
    int j = (paramInt2 & 0xFF000000) >> 24 & 0xFF;

    int k = 255;
    if (i + j == 0) {
      i = 1;
      j = 1;
      k = 0;
    }

    int m = (paramInt1 >> 16 & 0xFF) * i;
    int n = (paramInt1 >> 8 & 0xFF) * i;
    int i1 = (paramInt1 & 0xFF) * i;

    int i2 = (paramInt2 >> 16 & 0xFF) * j;
    int i3 = (paramInt2 >> 8 & 0xFF) * j;
    int i4 = (paramInt2 & 0xFF) * j;

    int i5 = (m + i2) / (i + j);
    int i6 = (n + i3) / (i + j);
    int i7 = (i1 + i4) / (i + j);

    return k << 24 | i5 << 16 | i6 << 8 | i7;
  }

  public void reloadAll() {
    Class<Textures> localTextures = Textures.class;
    BufferedImage localBufferedImage1;
    for (Iterator localIterator = this.loadedImages.keySet().iterator(); localIterator.hasNext(); ) { int i = ((Integer)localIterator.next()).intValue();
      localBufferedImage1 = (BufferedImage)this.loadedImages.get(i);
      loadTexture(localBufferedImage1, i);
    }
    Iterator<String> localIterator;
	for (localIterator = this.idMap.keySet().iterator(); localIterator.hasNext(); ) { String str = (String)localIterator.next();
      try {
        localBufferedImage1 = readImage(localTextures.getResourceAsStream(str));
        int j = ((Integer)this.idMap.get(str)).intValue();
        loadTexture(localBufferedImage1, j);
        this.blur = false;
        this.clamp = false;
      } catch (IOException localIOException1) {
        localIOException1.printStackTrace();
      }
    }
    String str;
    for (localIterator = this.pixelsMap.keySet().iterator(); localIterator.hasNext(); ) { str = (String)localIterator.next();
      try {
        BufferedImage localBufferedImage2 = readImage(localTextures.getResourceAsStream(str));
        loadTexturePixels(localBufferedImage2, (int[])(int[])this.pixelsMap.get(str));
        this.blur = false;
        this.clamp = false;
      } catch (IOException localIOException2) {
        localIOException2.printStackTrace();
      } }
  }

  private BufferedImage readImage(InputStream paramInputStream) throws IOException
  {
    BufferedImage localBufferedImage = ImageIO.read(paramInputStream);
    paramInputStream.close();
    return localBufferedImage;
  }

  public void bind(int paramInt) {
    if (paramInt < 0) return;
    GL11.glBindTexture(3553, paramInt);
  }

  public void bind(String paramString) {
    bind(loadTexture(paramString));
  }
}