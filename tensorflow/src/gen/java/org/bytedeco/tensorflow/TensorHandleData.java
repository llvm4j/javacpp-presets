// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TensorHandleData extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TensorHandleData(Pointer p) { super(p); }


  // Different tensor handles support a set of these calls. In some cases these
  // are resolved with a Tensor or TensorShape. Typically if the handle is not
  // ready, none of these are supported operations.
  public native @ByVal Status Tensor(@Cast("const tensorflow::Tensor**") PointerPointer t);
  public native @ByVal Status Tensor(@Const @ByPtrPtr Tensor t);
  public native @ByVal Status TensorValue(TensorValue t);
  public native @ByVal Status Shape(TensorShape shape);
  public native @ByVal Status NumDims(IntPointer num_dims);
  public native @ByVal Status NumDims(IntBuffer num_dims);
  public native @ByVal Status NumDims(int... num_dims);
  public native @ByVal Status Dim(int dim_index, @Cast("tensorflow::int64*") LongPointer dim);
  public native @ByVal Status Dim(int dim_index, @Cast("tensorflow::int64*") LongBuffer dim);
  public native @ByVal Status Dim(int dim_index, @Cast("tensorflow::int64*") long... dim);
  public native @ByVal Status NumElements(@Cast("tensorflow::int64*") LongPointer num_elements);
  public native @ByVal Status NumElements(@Cast("tensorflow::int64*") LongBuffer num_elements);
  public native @ByVal Status NumElements(@Cast("tensorflow::int64*") long... num_elements);

  public native @StdString BytePointer DebugString();
}