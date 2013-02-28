package com.mojang.spacegame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBShaderObjects;

public class Shader
{
  public boolean useShader = true;

  public int shader = 0;
  public int vertShader;
  public int fragShader;

  public Shader(String name)
  {
    this.shader = ARBShaderObjects.glCreateProgramObjectARB();
    if (this.shader != 0) {
      this.vertShader = createVertShader("/shader/" + name + ".vert.txt");
      this.fragShader = createFragShader("/shader/" + name + ".frag.txt");
    } else {
      this.useShader = false;
    }

    if ((this.vertShader != 0) && (this.fragShader != 0)) {
      ARBShaderObjects.glAttachObjectARB(this.shader, this.vertShader);
      ARBShaderObjects.glAttachObjectARB(this.shader, this.fragShader);

      ARBShaderObjects.glLinkProgramARB(this.shader);
      if (ARBShaderObjects.glGetObjectParameteriARB(this.shader, 35714) == 0) {
        printLogInfo(this.shader);
        this.useShader = false;
      }
      ARBShaderObjects.glValidateProgramARB(this.shader);
      if (ARBShaderObjects.glGetObjectParameteriARB(this.shader, 35715) == 0) {
        printLogInfo(this.shader);
        this.useShader = false;
      }
    } else {
      this.useShader = false;
    }
  }

  private int createVertShader(String filename) {
    int vertShader = ARBShaderObjects.glCreateShaderObjectARB(35633);
    if (vertShader == 0) {
      return 0;
    }
    String vertexCode = "";
    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(Shader.class.getResourceAsStream(filename)));
      String line;
      while ((line = reader.readLine()) != null)
      {
//        String line;
        vertexCode = vertexCode + line + "\n";
      }
    } catch (Exception e) {
      System.out.println("Fail reading vertex shading code");
      return 0;
    }
    String line;
    ARBShaderObjects.glShaderSourceARB(vertShader, vertexCode);
    ARBShaderObjects.glCompileShaderARB(vertShader);

    if (ARBShaderObjects.glGetObjectParameteriARB(vertShader, 35713) == 0) {
      printLogInfo(vertShader);
      vertShader = 0;
    }
    return vertShader;
  }

  private int createFragShader(String filename) {
    int fragShader = ARBShaderObjects.glCreateShaderObjectARB(35632);
    if (fragShader == 0) {
      return 0;
    }
    String fragCode = "";
    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(Shader.class.getResourceAsStream(filename)));
      String line;
      while ((line = reader.readLine()) != null)
      {
//        String line;
        fragCode = fragCode + line + "\n";
      }
    } catch (Exception e) {
      System.out.println("Fail reading fragment shading code");
      return 0;
    }
    String line;
    ARBShaderObjects.glShaderSourceARB(fragShader, fragCode);
    ARBShaderObjects.glCompileShaderARB(fragShader);
    if (ARBShaderObjects.glGetObjectParameteriARB(fragShader, 35713) == 0) {
      printLogInfo(fragShader);
      fragShader = 0;
    }
    return fragShader;
  }

  private static boolean printLogInfo(int obj) {
    IntBuffer iVal = BufferUtils.createIntBuffer(1);
    ARBShaderObjects.glGetObjectParameterARB(obj, 35716, iVal);

    int length = iVal.get();
    if (length > 1)
    {
      ByteBuffer infoLog = BufferUtils.createByteBuffer(length);
      iVal.flip();
      ARBShaderObjects.glGetInfoLogARB(obj, iVal, infoLog);
      byte[] infoBytes = new byte[length];
      infoLog.get(infoBytes);
      String out = new String(infoBytes);
      System.out.println("Info log:\n" + out);
    } else {
      return true;
    }return false;
  }

  public void bind(String name, int val) {
    int loc = ARBShaderObjects.glGetUniformLocationARB(this.shader, name);
    ARBShaderObjects.glUniform1iARB(loc, val);
  }

  public void enable()
  {
    ARBShaderObjects.glUseProgramObjectARB(this.shader);
  }

  public void disable() {
    ARBShaderObjects.glUseProgramObjectARB(0);
  }
}