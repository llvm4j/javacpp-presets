// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorrt.nvinfer;

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

import static org.bytedeco.tensorrt.global.nvinfer.*;


/** \class IResizeLayer
 * 
 *  \brief A resize layer in a network definition.
 * 
 *  Resize layer can be used for resizing a ND tensor.
 * 
 *  Resize layer currently supports the following configurations:
 *      -   ResizeMode::kNEAREST - resizes innermost {@code m} dimensions of ND, where 0 < m <= min(8, N) and N > 0
 *      -   ResizeMode::kLINEAR - resizes innermost {@code m} dimensions of ND, where 0 < m <= min(3, N) and N > 0
 * 
 *  Default resize mode is ResizeMode::kNEAREST.
 *  Resize layer provides two ways to resize tensor dimensions.
 *      -   Set output dimensions directly. It can be done for static as well as dynamic resize layer.
 *          Static resize layer requires output dimensions to be known at build-time.
 *          Dynamic resize layer requires output dimensions to be set as one of the input tensors.
 *      -   Set scales for resize. Each output dimension is calculated as floor(input dimension * scale).
 *          Only static resize layer allows setting scales where the scales are known at build-time.
 * 
 *  \warning Do not inherit from this class, as doing so will break forward-compatibility of the API and ABI.
 *  */
@Namespace("nvinfer1") @Properties(inherit = org.bytedeco.tensorrt.presets.nvinfer.class)
public class IResizeLayer extends ILayer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IResizeLayer(Pointer p) { super(p); }

    /**
     *  \brief Set the output dimensions.
     * 
     *  @param dimensions The output dimensions. Number of output dimensions must be the same as the number of input dimensions.
     * 
     *  If there is a second input, i.e. resize layer is dynamic,
     *  calling setOutputDimensions() is an error and does not update the
     *  dimensions.
     * 
     *  Output dimensions can be specified directly, or via scale factors relative to input dimensions.
     *  Scales for resize can be provided using setScales().
     * 
     *  @see setScales
     *  @see getOutputDimensions
     *  */
    
    
    //!
    //!
    //!
    public native void setOutputDimensions(@ByVal Dims dimensions);

    /**
     *  \brief Get the output dimensions.
     * 
     *  @return The output dimensions.
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    public native @ByVal Dims getOutputDimensions();

    /**
     *  \brief Set the resize scales.
     * 
     *  @param scales An array of resize scales.
     *  @param nbScales Number of scales. Number of scales must be equal to the number of input dimensions.
     * 
     *  If there is a second input, i.e. resize layer is dynamic,
     *  calling setScales() is an error and does not update the scales.
     * 
     *  Output dimensions are calculated as follows:
     *  outputDims[i] = floor(inputDims[i] * scales[i])
     * 
     *  Output dimensions can be specified directly, or via scale factors relative to input dimensions.
     *  Output dimensions can be provided directly using setOutputDimensions().
     * 
     *  @see setOutputDimensions
     *  @see getScales
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    //!
    public native void setScales(@Const FloatPointer scales, int nbScales);
    public native void setScales(@Const FloatBuffer scales, int nbScales);
    public native void setScales(@Const float[] scales, int nbScales);

    /**
     *  \brief Copies resize scales to scales[0, ..., nbScales-1], where nbScales is the number of scales that were set.
     * 
     *  @param size The number of scales to get. If size != nbScales, no scales will be copied.
     * 
     *  @param scales Pointer to where to copy the scales. Scales will be copied only if
     *                size == nbScales and scales != nullptr.
     * 
     *  In case the size is not known consider using size = 0 and scales = nullptr. This method will return
     *  the number of resize scales.
     * 
     *  @return The number of resize scales i.e. nbScales if scales were set.
     *          Return -1 in case no scales were set or resize layer is used in dynamic mode.
     *  */
    
    
    //!
    //!
    //!
    //!
    public native int getScales(int size, FloatPointer scales);
    public native int getScales(int size, FloatBuffer scales);
    public native int getScales(int size, float[] scales);

    /**
     *  \brief Set resize mode for an input tensor.
     * 
     *  Supported resize modes are Nearest Neighbor and Linear.
     * 
     *  @see ResizeMode
     *  */
    
    
    //!
    //!
    //!
    public native void setResizeMode(ResizeMode resizeMode);
    public native void setResizeMode(@Cast("nvinfer1::ResizeMode") int resizeMode);

    /**
     *  \brief Get resize mode for an input tensor.
     * 
     *  @return The resize mode.
     *  */
    
    
    //!
    //!
    //!
    //!
    public native ResizeMode getResizeMode();

    /**
     *  \brief Set whether to align corners while resizing.
     * 
     *  If true, the centers of the 4 corner pixels of both input and output
     *  tensors are aligned i.e. preserves the values of corner
     *  pixels.
     * 
     *  Default: false.
     *  */
    
    
    //!
    //!
    //!
    public native void setAlignCorners(@Cast("bool") boolean alignCorners);

    /**
     *  \brief True if align corners has been set.
     * 
     *  @return True if align corners has been set, false otherwise.
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    //!
    //!
    public native @Cast("bool") boolean getAlignCorners();

    /**
     *  \brief Append or replace an input of this layer with a specific tensor
     * 
     *  @param index the index of the input to modify.
     *  @param tensor the new input tensor
     * 
     *  Sets the input tensor for the given index. The index must be 0 for a static resize layer.
     *  A static resize layer is converted to a dynamic resize layer by calling setInput with an index 1.
     *  A dynamic resize layer cannot be converted back to a static resize layer.
     * 
     *  For a dynamic resize layer, the values 0 and 1 are valid.
     *  The indices in the dynamic case are as follows:
     * 
     *  Index | Description
     *    0   | Data or Shape tensor to be resized.
     *    1   | The output dimensions, as a 1D Int32 shape tensor.
     * 
     *  If this function is called with a value 1, then the function getNbInputs() changes
     *  from returning 1 to 2.
     *  */
    public native void setInput(int index, @ByRef ITensor tensor);
}
