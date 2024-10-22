/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.gsoc.freebase.wikilinks.model;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mention implements org.apache.thrift.TBase<Mention, Mention._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Mention");

  private static final org.apache.thrift.protocol.TField WIKI_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("wiki_url", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ANCHOR_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("anchor_text", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField RAW_TEXT_OFFSET_FIELD_DESC = new org.apache.thrift.protocol.TField("raw_text_offset", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField CONTEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("context", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField FREEBASE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("freebase_id", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MentionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MentionTupleSchemeFactory());
  }

  public String wiki_url; // required
  public String anchor_text; // required
  public int raw_text_offset; // required
  public Context context; // optional
  public String freebase_id; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    WIKI_URL((short)1, "wiki_url"),
    ANCHOR_TEXT((short)2, "anchor_text"),
    RAW_TEXT_OFFSET((short)3, "raw_text_offset"),
    CONTEXT((short)4, "context"),
    FREEBASE_ID((short)5, "freebase_id");

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
        case 1: // WIKI_URL
          return WIKI_URL;
        case 2: // ANCHOR_TEXT
          return ANCHOR_TEXT;
        case 3: // RAW_TEXT_OFFSET
          return RAW_TEXT_OFFSET;
        case 4: // CONTEXT
          return CONTEXT;
        case 5: // FREEBASE_ID
          return FREEBASE_ID;
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
  private static final int __RAW_TEXT_OFFSET_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.CONTEXT,_Fields.FREEBASE_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.WIKI_URL, new org.apache.thrift.meta_data.FieldMetaData("wiki_url", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ANCHOR_TEXT, new org.apache.thrift.meta_data.FieldMetaData("anchor_text", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RAW_TEXT_OFFSET, new org.apache.thrift.meta_data.FieldMetaData("raw_text_offset", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CONTEXT, new org.apache.thrift.meta_data.FieldMetaData("context", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Context.class)));
    tmpMap.put(_Fields.FREEBASE_ID, new org.apache.thrift.meta_data.FieldMetaData("freebase_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Mention.class, metaDataMap);
  }

  public Mention() {
  }

  public Mention(
    String wiki_url,
    String anchor_text,
    int raw_text_offset)
  {
    this();
    this.wiki_url = wiki_url;
    this.anchor_text = anchor_text;
    this.raw_text_offset = raw_text_offset;
    setRaw_text_offsetIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Mention(Mention other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetWiki_url()) {
      this.wiki_url = other.wiki_url;
    }
    if (other.isSetAnchor_text()) {
      this.anchor_text = other.anchor_text;
    }
    this.raw_text_offset = other.raw_text_offset;
    if (other.isSetContext()) {
      this.context = new Context(other.context);
    }
    if (other.isSetFreebase_id()) {
      this.freebase_id = other.freebase_id;
    }
  }

  public Mention deepCopy() {
    return new Mention(this);
  }

  @Override
  public void clear() {
    this.wiki_url = null;
    this.anchor_text = null;
    setRaw_text_offsetIsSet(false);
    this.raw_text_offset = 0;
    this.context = null;
    this.freebase_id = null;
  }

  public String getWiki_url() {
    return this.wiki_url;
  }

  public Mention setWiki_url(String wiki_url) {
    this.wiki_url = wiki_url;
    return this;
  }

  public void unsetWiki_url() {
    this.wiki_url = null;
  }

  /** Returns true if field wiki_url is set (has been assigned a value) and false otherwise */
  public boolean isSetWiki_url() {
    return this.wiki_url != null;
  }

  public void setWiki_urlIsSet(boolean value) {
    if (!value) {
      this.wiki_url = null;
    }
  }

  public String getAnchor_text() {
    return this.anchor_text;
  }

  public Mention setAnchor_text(String anchor_text) {
    this.anchor_text = anchor_text;
    return this;
  }

  public void unsetAnchor_text() {
    this.anchor_text = null;
  }

  /** Returns true if field anchor_text is set (has been assigned a value) and false otherwise */
  public boolean isSetAnchor_text() {
    return this.anchor_text != null;
  }

  public void setAnchor_textIsSet(boolean value) {
    if (!value) {
      this.anchor_text = null;
    }
  }

  public int getRaw_text_offset() {
    return this.raw_text_offset;
  }

  public Mention setRaw_text_offset(int raw_text_offset) {
    this.raw_text_offset = raw_text_offset;
    setRaw_text_offsetIsSet(true);
    return this;
  }

  public void unsetRaw_text_offset() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __RAW_TEXT_OFFSET_ISSET_ID);
  }

  /** Returns true if field raw_text_offset is set (has been assigned a value) and false otherwise */
  public boolean isSetRaw_text_offset() {
    return EncodingUtils.testBit(__isset_bitfield, __RAW_TEXT_OFFSET_ISSET_ID);
  }

  public void setRaw_text_offsetIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __RAW_TEXT_OFFSET_ISSET_ID, value);
  }

  public Context getContext() {
    return this.context;
  }

  public Mention setContext(Context context) {
    this.context = context;
    return this;
  }

  public void unsetContext() {
    this.context = null;
  }

  /** Returns true if field context is set (has been assigned a value) and false otherwise */
  public boolean isSetContext() {
    return this.context != null;
  }

  public void setContextIsSet(boolean value) {
    if (!value) {
      this.context = null;
    }
  }

  public String getFreebase_id() {
    return this.freebase_id;
  }

  public Mention setFreebase_id(String freebase_id) {
    this.freebase_id = freebase_id;
    return this;
  }

  public void unsetFreebase_id() {
    this.freebase_id = null;
  }

  /** Returns true if field freebase_id is set (has been assigned a value) and false otherwise */
  public boolean isSetFreebase_id() {
    return this.freebase_id != null;
  }

  public void setFreebase_idIsSet(boolean value) {
    if (!value) {
      this.freebase_id = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case WIKI_URL:
      if (value == null) {
        unsetWiki_url();
      } else {
        setWiki_url((String)value);
      }
      break;

    case ANCHOR_TEXT:
      if (value == null) {
        unsetAnchor_text();
      } else {
        setAnchor_text((String)value);
      }
      break;

    case RAW_TEXT_OFFSET:
      if (value == null) {
        unsetRaw_text_offset();
      } else {
        setRaw_text_offset((Integer)value);
      }
      break;

    case CONTEXT:
      if (value == null) {
        unsetContext();
      } else {
        setContext((Context)value);
      }
      break;

    case FREEBASE_ID:
      if (value == null) {
        unsetFreebase_id();
      } else {
        setFreebase_id((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case WIKI_URL:
      return getWiki_url();

    case ANCHOR_TEXT:
      return getAnchor_text();

    case RAW_TEXT_OFFSET:
      return Integer.valueOf(getRaw_text_offset());

    case CONTEXT:
      return getContext();

    case FREEBASE_ID:
      return getFreebase_id();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case WIKI_URL:
      return isSetWiki_url();
    case ANCHOR_TEXT:
      return isSetAnchor_text();
    case RAW_TEXT_OFFSET:
      return isSetRaw_text_offset();
    case CONTEXT:
      return isSetContext();
    case FREEBASE_ID:
      return isSetFreebase_id();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Mention)
      return this.equals((Mention)that);
    return false;
  }

  public boolean equals(Mention that) {
    if (that == null)
      return false;

    boolean this_present_wiki_url = true && this.isSetWiki_url();
    boolean that_present_wiki_url = true && that.isSetWiki_url();
    if (this_present_wiki_url || that_present_wiki_url) {
      if (!(this_present_wiki_url && that_present_wiki_url))
        return false;
      if (!this.wiki_url.equals(that.wiki_url))
        return false;
    }

    boolean this_present_anchor_text = true && this.isSetAnchor_text();
    boolean that_present_anchor_text = true && that.isSetAnchor_text();
    if (this_present_anchor_text || that_present_anchor_text) {
      if (!(this_present_anchor_text && that_present_anchor_text))
        return false;
      if (!this.anchor_text.equals(that.anchor_text))
        return false;
    }

    boolean this_present_raw_text_offset = true;
    boolean that_present_raw_text_offset = true;
    if (this_present_raw_text_offset || that_present_raw_text_offset) {
      if (!(this_present_raw_text_offset && that_present_raw_text_offset))
        return false;
      if (this.raw_text_offset != that.raw_text_offset)
        return false;
    }

    boolean this_present_context = true && this.isSetContext();
    boolean that_present_context = true && that.isSetContext();
    if (this_present_context || that_present_context) {
      if (!(this_present_context && that_present_context))
        return false;
      if (!this.context.equals(that.context))
        return false;
    }

    boolean this_present_freebase_id = true && this.isSetFreebase_id();
    boolean that_present_freebase_id = true && that.isSetFreebase_id();
    if (this_present_freebase_id || that_present_freebase_id) {
      if (!(this_present_freebase_id && that_present_freebase_id))
        return false;
      if (!this.freebase_id.equals(that.freebase_id))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Mention other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Mention typedOther = (Mention)other;

    lastComparison = Boolean.valueOf(isSetWiki_url()).compareTo(typedOther.isSetWiki_url());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWiki_url()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.wiki_url, typedOther.wiki_url);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAnchor_text()).compareTo(typedOther.isSetAnchor_text());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAnchor_text()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.anchor_text, typedOther.anchor_text);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRaw_text_offset()).compareTo(typedOther.isSetRaw_text_offset());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRaw_text_offset()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.raw_text_offset, typedOther.raw_text_offset);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContext()).compareTo(typedOther.isSetContext());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContext()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.context, typedOther.context);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFreebase_id()).compareTo(typedOther.isSetFreebase_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFreebase_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.freebase_id, typedOther.freebase_id);
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
    StringBuilder sb = new StringBuilder("Mention(");
    boolean first = true;

    sb.append("wiki_url:");
    if (this.wiki_url == null) {
      sb.append("null");
    } else {
      sb.append(this.wiki_url);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("anchor_text:");
    if (this.anchor_text == null) {
      sb.append("null");
    } else {
      sb.append(this.anchor_text);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("raw_text_offset:");
    sb.append(this.raw_text_offset);
    first = false;
    if (isSetContext()) {
      if (!first) sb.append(", ");
      sb.append("context:");
      if (this.context == null) {
        sb.append("null");
      } else {
        sb.append(this.context);
      }
      first = false;
    }
    if (isSetFreebase_id()) {
      if (!first) sb.append(", ");
      sb.append("freebase_id:");
      if (this.freebase_id == null) {
        sb.append("null");
      } else {
        sb.append(this.freebase_id);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (context != null) {
      context.validate();
    }
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MentionStandardSchemeFactory implements SchemeFactory {
    public MentionStandardScheme getScheme() {
      return new MentionStandardScheme();
    }
  }

  private static class MentionStandardScheme extends StandardScheme<Mention> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Mention struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // WIKI_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.wiki_url = iprot.readString();
              struct.setWiki_urlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ANCHOR_TEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.anchor_text = iprot.readString();
              struct.setAnchor_textIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // RAW_TEXT_OFFSET
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.raw_text_offset = iprot.readI32();
              struct.setRaw_text_offsetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CONTEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.context = new Context();
              struct.context.read(iprot);
              struct.setContextIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // FREEBASE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.freebase_id = iprot.readString();
              struct.setFreebase_idIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Mention struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.wiki_url != null) {
        oprot.writeFieldBegin(WIKI_URL_FIELD_DESC);
        oprot.writeString(struct.wiki_url);
        oprot.writeFieldEnd();
      }
      if (struct.anchor_text != null) {
        oprot.writeFieldBegin(ANCHOR_TEXT_FIELD_DESC);
        oprot.writeString(struct.anchor_text);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(RAW_TEXT_OFFSET_FIELD_DESC);
      oprot.writeI32(struct.raw_text_offset);
      oprot.writeFieldEnd();
      if (struct.context != null) {
        if (struct.isSetContext()) {
          oprot.writeFieldBegin(CONTEXT_FIELD_DESC);
          struct.context.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.freebase_id != null) {
        if (struct.isSetFreebase_id()) {
          oprot.writeFieldBegin(FREEBASE_ID_FIELD_DESC);
          oprot.writeString(struct.freebase_id);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MentionTupleSchemeFactory implements SchemeFactory {
    public MentionTupleScheme getScheme() {
      return new MentionTupleScheme();
    }
  }

  private static class MentionTupleScheme extends TupleScheme<Mention> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Mention struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetWiki_url()) {
        optionals.set(0);
      }
      if (struct.isSetAnchor_text()) {
        optionals.set(1);
      }
      if (struct.isSetRaw_text_offset()) {
        optionals.set(2);
      }
      if (struct.isSetContext()) {
        optionals.set(3);
      }
      if (struct.isSetFreebase_id()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetWiki_url()) {
        oprot.writeString(struct.wiki_url);
      }
      if (struct.isSetAnchor_text()) {
        oprot.writeString(struct.anchor_text);
      }
      if (struct.isSetRaw_text_offset()) {
        oprot.writeI32(struct.raw_text_offset);
      }
      if (struct.isSetContext()) {
        struct.context.write(oprot);
      }
      if (struct.isSetFreebase_id()) {
        oprot.writeString(struct.freebase_id);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Mention struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.wiki_url = iprot.readString();
        struct.setWiki_urlIsSet(true);
      }
      if (incoming.get(1)) {
        struct.anchor_text = iprot.readString();
        struct.setAnchor_textIsSet(true);
      }
      if (incoming.get(2)) {
        struct.raw_text_offset = iprot.readI32();
        struct.setRaw_text_offsetIsSet(true);
      }
      if (incoming.get(3)) {
        struct.context = new Context();
        struct.context.read(iprot);
        struct.setContextIsSet(true);
      }
      if (incoming.get(4)) {
        struct.freebase_id = iprot.readString();
        struct.setFreebase_idIsSet(true);
      }
    }
  }

}

