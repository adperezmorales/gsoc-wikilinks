/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.gsoc.freebase.wikilinks.model;

import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

public class Context implements org.apache.thrift.TBase<Context, Context._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Context");

  private static final org.apache.thrift.protocol.TField LEFT_FIELD_DESC = new org.apache.thrift.protocol.TField("left", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField RIGHT_FIELD_DESC = new org.apache.thrift.protocol.TField("right", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField MIDDLE_FIELD_DESC = new org.apache.thrift.protocol.TField("middle", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ContextStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ContextTupleSchemeFactory());
  }

  public String left; // required
  public String right; // required
  public String middle; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    LEFT((short)1, "left"),
    RIGHT((short)2, "right"),
    MIDDLE((short)3, "middle");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // LEFT
          return LEFT;
        case 2: // RIGHT
          return RIGHT;
        case 3: // MIDDLE
          return MIDDLE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LEFT, new org.apache.thrift.meta_data.FieldMetaData("left", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RIGHT, new org.apache.thrift.meta_data.FieldMetaData("right", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MIDDLE, new org.apache.thrift.meta_data.FieldMetaData("middle", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Context.class, metaDataMap);
  }

  public Context() {
  }

  public Context(
    String left,
    String right,
    String middle)
  {
    this();
    this.left = left;
    this.right = right;
    this.middle = middle;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Context(Context other) {
    if (other.isSetLeft()) {
      this.left = other.left;
    }
    if (other.isSetRight()) {
      this.right = other.right;
    }
    if (other.isSetMiddle()) {
      this.middle = other.middle;
    }
  }

  public Context deepCopy() {
    return new Context(this);
  }

  @Override
  public void clear() {
    this.left = null;
    this.right = null;
    this.middle = null;
  }

  public String getLeft() {
    return this.left;
  }

  public Context setLeft(String left) {
    this.left = left;
    return this;
  }

  public void unsetLeft() {
    this.left = null;
  }

  /** Returns true if field left is set (has been assigned a value) and false otherwise */
  public boolean isSetLeft() {
    return this.left != null;
  }

  public void setLeftIsSet(boolean value) {
    if (!value) {
      this.left = null;
    }
  }

  public String getRight() {
    return this.right;
  }

  public Context setRight(String right) {
    this.right = right;
    return this;
  }

  public void unsetRight() {
    this.right = null;
  }

  /** Returns true if field right is set (has been assigned a value) and false otherwise */
  public boolean isSetRight() {
    return this.right != null;
  }

  public void setRightIsSet(boolean value) {
    if (!value) {
      this.right = null;
    }
  }

  public String getMiddle() {
    return this.middle;
  }

  public Context setMiddle(String middle) {
    this.middle = middle;
    return this;
  }

  public void unsetMiddle() {
    this.middle = null;
  }

  /** Returns true if field middle is set (has been assigned a value) and false otherwise */
  public boolean isSetMiddle() {
    return this.middle != null;
  }

  public void setMiddleIsSet(boolean value) {
    if (!value) {
      this.middle = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LEFT:
      if (value == null) {
        unsetLeft();
      } else {
        setLeft((String)value);
      }
      break;

    case RIGHT:
      if (value == null) {
        unsetRight();
      } else {
        setRight((String)value);
      }
      break;

    case MIDDLE:
      if (value == null) {
        unsetMiddle();
      } else {
        setMiddle((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LEFT:
      return getLeft();

    case RIGHT:
      return getRight();

    case MIDDLE:
      return getMiddle();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LEFT:
      return isSetLeft();
    case RIGHT:
      return isSetRight();
    case MIDDLE:
      return isSetMiddle();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Context)
      return this.equals((Context)that);
    return false;
  }

  public boolean equals(Context that) {
    if (that == null)
      return false;

    boolean this_present_left = true && this.isSetLeft();
    boolean that_present_left = true && that.isSetLeft();
    if (this_present_left || that_present_left) {
      if (!(this_present_left && that_present_left))
        return false;
      if (!this.left.equals(that.left))
        return false;
    }

    boolean this_present_right = true && this.isSetRight();
    boolean that_present_right = true && that.isSetRight();
    if (this_present_right || that_present_right) {
      if (!(this_present_right && that_present_right))
        return false;
      if (!this.right.equals(that.right))
        return false;
    }

    boolean this_present_middle = true && this.isSetMiddle();
    boolean that_present_middle = true && that.isSetMiddle();
    if (this_present_middle || that_present_middle) {
      if (!(this_present_middle && that_present_middle))
        return false;
      if (!this.middle.equals(that.middle))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Context other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Context typedOther = (Context)other;

    lastComparison = Boolean.valueOf(isSetLeft()).compareTo(typedOther.isSetLeft());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLeft()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.left, typedOther.left);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRight()).compareTo(typedOther.isSetRight());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRight()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.right, typedOther.right);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMiddle()).compareTo(typedOther.isSetMiddle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMiddle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.middle, typedOther.middle);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Context(");
    boolean first = true;

    sb.append("left:");
    if (this.left == null) {
      sb.append("null");
    } else {
      sb.append(this.left);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("right:");
    if (this.right == null) {
      sb.append("null");
    } else {
      sb.append(this.right);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("middle:");
    if (this.middle == null) {
      sb.append("null");
    } else {
      sb.append(this.middle);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ContextStandardSchemeFactory implements SchemeFactory {
    public ContextStandardScheme getScheme() {
      return new ContextStandardScheme();
    }
  }

  private static class ContextStandardScheme extends StandardScheme<Context> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Context struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // LEFT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.left = iprot.readString();
              struct.setLeftIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RIGHT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.right = iprot.readString();
              struct.setRightIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MIDDLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.middle = iprot.readString();
              struct.setMiddleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Context struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.left != null) {
        oprot.writeFieldBegin(LEFT_FIELD_DESC);
        oprot.writeString(struct.left);
        oprot.writeFieldEnd();
      }
      if (struct.right != null) {
        oprot.writeFieldBegin(RIGHT_FIELD_DESC);
        oprot.writeString(struct.right);
        oprot.writeFieldEnd();
      }
      if (struct.middle != null) {
        oprot.writeFieldBegin(MIDDLE_FIELD_DESC);
        oprot.writeString(struct.middle);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ContextTupleSchemeFactory implements SchemeFactory {
    public ContextTupleScheme getScheme() {
      return new ContextTupleScheme();
    }
  }

  private static class ContextTupleScheme extends TupleScheme<Context> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Context struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetLeft()) {
        optionals.set(0);
      }
      if (struct.isSetRight()) {
        optionals.set(1);
      }
      if (struct.isSetMiddle()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetLeft()) {
        oprot.writeString(struct.left);
      }
      if (struct.isSetRight()) {
        oprot.writeString(struct.right);
      }
      if (struct.isSetMiddle()) {
        oprot.writeString(struct.middle);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Context struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.left = iprot.readString();
        struct.setLeftIsSet(true);
      }
      if (incoming.get(1)) {
        struct.right = iprot.readString();
        struct.setRightIsSet(true);
      }
      if (incoming.get(2)) {
        struct.middle = iprot.readString();
        struct.setMiddleIsSet(true);
      }
    }
  }

}

