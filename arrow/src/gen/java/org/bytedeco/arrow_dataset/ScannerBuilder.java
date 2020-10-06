// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_dataset;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

import static org.bytedeco.arrow.global.arrow_dataset.*;


/** \brief ScannerBuilder is a factory class to construct a Scanner. It is used
 *  to pass information, notably a potential filter expression and a subset of
 *  columns to materialize. */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class ScannerBuilder extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ScannerBuilder(Pointer p) { super(p); }

  public ScannerBuilder(@SharedPtr @ByVal Dataset dataset,
                   @SharedPtr ScanContext scan_context) { super((Pointer)null); allocate(dataset, scan_context); }
  private native void allocate(@SharedPtr @ByVal Dataset dataset,
                   @SharedPtr ScanContext scan_context);

  
  ///
  ///
  ///
  public ScannerBuilder(@SharedPtr @ByVal Schema schema, @SharedPtr @ByVal Fragment fragment,
                   @SharedPtr ScanContext scan_context) { super((Pointer)null); allocate(schema, fragment, scan_context); }
  private native void allocate(@SharedPtr @ByVal Schema schema, @SharedPtr @ByVal Fragment fragment,
                   @SharedPtr ScanContext scan_context);

  /** \brief Set the subset of columns to materialize.
   * 
   *  This subset will be passed down to Sources and corresponding Fragments.
   *  The goal is to avoid loading/copying/deserializing columns that will
   *  not be required further down the compute chain.
   * 
   *  @param columns [in] list of columns to project. Order and duplicates will
   *             be preserved.
   * 
   *  @return Failure if any column name does not exists in the dataset's
   *          Schema. */
  
  ///
  ///
  ///
  public native @ByVal Status Project(@ByVal StringVector columns);

  /** \brief Set the filter expression to return only rows matching the filter.
   * 
   *  The predicate will be passed down to Sources and corresponding
   *  Fragments to exploit predicate pushdown if possible using
   *  partition information or Fragment internal metadata, e.g. Parquet statistics.
   * 
   *  @param filter [in] expression to filter rows with.
   * 
   *  @return Failure if any referenced columns does not exist in the dataset's
   *          Schema. */
  public native @ByVal Status Filter(@SharedPtr @ByVal Expression filter);

  /** \brief Indicate if the Scanner should make use of the available
   *         ThreadPool found in ScanContext; */
  
  ///
  ///
  public native @ByVal Status UseThreads(@Cast("bool") boolean use_threads/*=true*/);
  public native @ByVal Status UseThreads();

  /** \brief Set the maximum number of rows per RecordBatch.
   * 
   *  @param batch_size [in] the maximum number of rows.
   *  @return An error if the number for batch is not greater than 0.
   * 
   *  This option provides a control limiting the memory owned by any RecordBatch. */
  public native @ByVal Status BatchSize(@Cast("int64_t") long batch_size);

  /** \brief Return the constructed now-immutable Scanner object */
  public native @ByVal ScannerResult Finish();

  public native @SharedPtr @ByVal Schema schema();
}