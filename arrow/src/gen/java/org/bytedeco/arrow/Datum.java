// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \class Datum
 *  \brief Variant type for various Arrow C++ data structures */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Datum extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Datum(Pointer p) { super(p); }

  public enum Kind { NONE(0), SCALAR(1), ARRAY(2), CHUNKED_ARRAY(3), RECORD_BATCH(4), TABLE(5), COLLECTION(6);

      public final int value;
      private Kind(int v) { this.value = v; }
      private Kind(Kind e) { this.value = e.value; }
      public Kind intern() { for (Kind e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }

  // Datums variants may have a length. This special value indicate that the
  // current variant does not have a length.
  @MemberGetter public static native @Cast("const int64_t") long kUnknownLength();
  public static final long kUnknownLength = kUnknownLength();

  

  /** \brief Empty datum, to be populated elsewhere */
  public Datum() { super((Pointer)null); allocate(); }
  private native void allocate();

  public Datum(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Scalar>"}) Scalar value) { super((Pointer)null); allocate(value); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Scalar>"}) Scalar value);

  public Datum(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData value) { super((Pointer)null); allocate(value); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData value);

  public Datum(@Const @ByRef Array value) { super((Pointer)null); allocate(value); }
  private native void allocate(@Const @ByRef Array value);                   // NOLINT implicit conversion  // NOLINT implicit conversion
  public Datum(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ChunkedArray>"}) ChunkedArray value) { super((Pointer)null); allocate(value); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ChunkedArray>"}) ChunkedArray value);  // NOLINT implicit conversion
  public Datum(@SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch value) { super((Pointer)null); allocate(value); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch value);   // NOLINT implicit conversion
  public Datum(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Table>"}) Table value) { super((Pointer)null); allocate(value); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Table>"}) Table value);         // NOLINT implicit conversion
  public Datum(@ByVal DatumVector value) { super((Pointer)null); allocate(value); }
  private native void allocate(@ByVal DatumVector value);             // NOLINT implicit conversion

  // Explicit constructors from const-refs. Can be expensive, prefer the
  // shared_ptr constructors

  // Cast from subtypes of Array to Datum

  // Convenience constructors
  public Datum(@Cast("bool") boolean value) { super((Pointer)null); allocate(value); }
  private native void allocate(@Cast("bool") boolean value);
  public Datum(byte value) { super((Pointer)null); allocate(value); }
  private native void allocate(byte value);
  public Datum(short value) { super((Pointer)null); allocate(value); }
  private native void allocate(short value);
  public Datum(int value) { super((Pointer)null); allocate(value); }
  private native void allocate(int value);
  public Datum(@Cast("int64_t") long value) { super((Pointer)null); allocate(value); }
  private native void allocate(@Cast("int64_t") long value);
  public Datum(float value) { super((Pointer)null); allocate(value); }
  private native void allocate(float value);
  public Datum(double value) { super((Pointer)null); allocate(value); }
  private native void allocate(double value);

  public Datum(@Const @ByRef Datum other) { super((Pointer)null); allocate(other); }
  @NoException private native void allocate(@Const @ByRef Datum other);

  public native @ByRef @Name("operator =") @NoException Datum put(@Const @ByRef Datum other);

  // Define move constructor and move assignment, for better performance

  public native Kind kind();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData array();

  public native ArrayData mutable_array();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array make_array();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::ChunkedArray>"}) ChunkedArray chunked_array();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch record_batch();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Table>"}) Table table();

  public native @Const @ByRef DatumVector collection();

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::Scalar>"}) Scalar scalar();

  public native @Cast("bool") boolean is_array();

  public native @Cast("bool") boolean is_arraylike();

  public native @Cast("bool") boolean is_scalar();

  /** \brief True if Datum contains a scalar or array-like data */
  public native @Cast("bool") boolean is_value();

  public native @Cast("bool") boolean is_collection();

  public native @Cast("int64_t") long null_count();

  /** \brief Return the shape (array or scalar) and type for supported kinds
   *  (ARRAY, CHUNKED_ARRAY, and SCALAR). Debug asserts otherwise */
  public native @ByVal ValueDescr descr();

  /** \brief Return the shape (array or scalar) for supported kinds (ARRAY,
   *  CHUNKED_ARRAY, and SCALAR). Debug asserts otherwise */
  
  ///
  public native ValueDescr.Shape shape();

  /** \brief The value type of the variant, if any
   * 
   *  @return nullptr if no type */
  
  ///
  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type();

  /** \brief The value length of the variant, if any
   * 
   *  @return kUnknownLength if no type */
  
  ///
  public native @Cast("int64_t") long length();

  /** \brief The array chunks of the variant, if any
   * 
   *  @return empty if not arraylike */
  public native @ByVal ArrayVector chunks();

  public native @Cast("bool") boolean Equals(@Const @ByRef Datum other);

  public native @Cast("bool") @Name("operator ==") boolean equals(@Const @ByRef Datum other);
  public native @Cast("bool") @Name("operator !=") boolean notEquals(@Const @ByRef Datum other);

  public native @StdString String ToString();
}