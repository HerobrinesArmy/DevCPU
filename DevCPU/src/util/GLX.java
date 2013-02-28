package util;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.ARBMultitexture;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GLContext;

import com.mojang.spacegame.MemoryTracker;

public class GLX
{
  public static int GL_TEXTURE0;
  public static int GL_TEXTURE1;
  private static boolean useArb = false;
  private static FloatBuffer fb = MemoryTracker.createFloatBuffer(4);

  public static void init() {
    useArb = (GLContext.getCapabilities().GL_ARB_multitexture) && (!GLContext.getCapabilities().OpenGL13);

    if (useArb) {
      GL_TEXTURE0 = 33984;
      GL_TEXTURE1 = 33985;
    } else {
      GL_TEXTURE0 = 33984;
      GL_TEXTURE1 = 33985;
    }
  }

  public static void glActiveTexture(int texture) {
    if (useArb)
      ARBMultitexture.glActiveTextureARB(texture);
    else
      GL13.glActiveTexture(texture);
  }

  public static void glClientActiveTexture(int texture)
  {
    if (useArb)
      ARBMultitexture.glClientActiveTextureARB(texture);
    else
      GL13.glClientActiveTexture(texture);
  }

  public static void glMultiTexCoord2f(int texture, float u, float v)
  {
    if (useArb)
      ARBMultitexture.glMultiTexCoord2fARB(texture, u, v);
    else
      GL13.glMultiTexCoord2f(texture, u, v);
  }

  public static FloatBuffer getf(float a, float b, float c)
  {
    fb.clear();
    fb.put(a).put(b).put(c);
    fb.flip();
    return fb;
  }

  public static FloatBuffer getf(float a, float b, float c, float d) {
    fb.clear();
    fb.put(a).put(b).put(c).put(d);
    fb.flip();
    return fb;
  }
}