// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorrt.nvparsers;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;
import org.bytedeco.cuda.cublas.*;
import static org.bytedeco.cuda.global.cublas.*;
import org.bytedeco.cuda.cudnn.*;
import static org.bytedeco.cuda.global.cudnn.*;
import org.bytedeco.cuda.nvrtc.*;
import static org.bytedeco.cuda.global.nvrtc.*;
import org.bytedeco.tensorrt.nvinfer.*;
import static org.bytedeco.tensorrt.global.nvinfer.*;

import static org.bytedeco.tensorrt.global.nvparsers.*;


/**
 *  \class IPluginFactoryV2
 * 
 *  \brief Plugin factory used to configure plugins.
 *  */
@Namespace("nvcaffeparser1") @Properties(inherit = org.bytedeco.tensorrt.presets.nvparsers.class)
public class IPluginFactoryV2 extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IPluginFactoryV2(Pointer p) { super(p); }

    /**
     *  \brief A user implemented function that determines if a layer configuration is provided by an IPluginV2.
     * 
     *  @param layerName Name of the layer which the user wishes to validate.
     *  */
    
    
    //!
    //!
    //!
    public native @Cast("bool") boolean isPluginV2(String layerName);
    public native @Cast("bool") boolean isPluginV2(@Cast("const char*") BytePointer layerName);

    /**
     *  \brief Creates a plugin.
     * 
     *  @param layerName Name of layer associated with the plugin.
     *  @param weights Weights used for the layer.
     *  @param nbWeights Number of weights.
     *  @param libNamespace Library Namespace associated with the plugin object
     *  */
    public native IPluginV2 createPlugin(String layerName, @Const Weights weights, int nbWeights, String libNamespace/*=""*/);
    public native IPluginV2 createPlugin(String layerName, @Const Weights weights, int nbWeights);
    public native IPluginV2 createPlugin(@Cast("const char*") BytePointer layerName, @Const Weights weights, int nbWeights, @Cast("const char*") BytePointer libNamespace/*=""*/);
    public native IPluginV2 createPlugin(@Cast("const char*") BytePointer layerName, @Const Weights weights, int nbWeights);
}
