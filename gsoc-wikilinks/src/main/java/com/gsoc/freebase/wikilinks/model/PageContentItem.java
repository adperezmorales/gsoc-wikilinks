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

public class PageContentItem implements org.apache.thrift.TBase<PageContentItem, PageContentItem._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PageContentItem");

  private static final org.apache.thrift.protocol.TField RAW_FIELD_DESC = new org.apache.thrift.protocol.TField("raw", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FULL_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("fullText", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ARTICLE_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("articleText", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DOM_FIELD_DESC = new org.apache.thrift.protocol.TField("dom", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PageContentItemStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PageContentItemTupleSchemeFactory());
  }

  public ByteBuffer raw; // optional
  public String fullText; // optional
  public String articleText; // optional
  public String dom; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RAW((short)1, "raw"),
    FULL_TEXT((short)2, "fullText"),
    ARTICLE_TEXT((short)3, "articleText"),
    DOM((short)4, "dom");

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
        case 1: // RAW
          return RAW;
        case 2: // FULL_TEXT
          return FULL_TEXT;
        case 3: // ARTICLE_TEXT
          return ARTICLE_TEXT;
        case 4: // DOM
          return DOM;
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
  private _Fields optionals[] = {_Fields.RAW,_Fields.FULL_TEXT,_Fields.ARTICLE_TEXT,_Fields.DOM};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RAW, new org.apache.thrift.meta_data.FieldMetaData("raw", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.FULL_TEXT, new org.apache.thrift.meta_data.FieldMetaData("fullText", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ARTICLE_TEXT, new org.apache.thrift.meta_data.FieldMetaData("articleText", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DOM, new org.apache.thrift.meta_data.FieldMetaData("dom", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PageContentItem.class, metaDataMap);
  }

  public PageContentItem() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PageContentItem(PageContentItem other) {
    if (other.isSetRaw()) {
      this.raw = org.apache.thrift.TBaseHelper.copyBinary(other.raw);
;
    }
    if (other.isSetFullText()) {
      this.fullText = other.fullText;
    }
    if (other.isSetArticleText()) {
      this.articleText = other.articleText;
    }
    if (other.isSetDom()) {
      this.dom = other.dom;
    }
  }

  public PageContentItem deepCopy() {
    return new PageContentItem(this);
  }

  @Override
  public void clear() {
    this.raw = null;
    this.fullText = null;
    this.articleText = null;
    this.dom = null;
  }

  public byte[] getRaw() {
    setRaw(org.apache.thrift.TBaseHelper.rightSize(raw));
    return raw == null ? null : raw.array();
  }

  public ByteBuffer bufferForRaw() {
    return raw;
  }

  public PageContentItem setRaw(byte[] raw) {
    setRaw(raw == null ? (ByteBuffer)null : ByteBuffer.wrap(raw));
    return this;
  }

  public PageContentItem setRaw(ByteBuffer raw) {
    this.raw = raw;
    return this;
  }

  public void unsetRaw() {
    this.raw = null;
  }

  /** Returns true if field raw is set (has been assigned a value) and false otherwise */
  public boolean isSetRaw() {
    return this.raw != null;
  }

  public void setRawIsSet(boolean value) {
    if (!value) {
      this.raw = null;
    }
  }

  public String getFullText() {
    return this.fullText;
  }

  public PageContentItem setFullText(String fullText) {
    this.fullText = fullText;
    return this;
  }

  public void unsetFullText() {
    this.fullText = null;
  }

  /** Returns true if field fullText is set (has been assigned a value) and false otherwise */
  public boolean isSetFullText() {
    return this.fullText != null;
  }

  public void setFullTextIsSet(boolean value) {
    if (!value) {
      this.fullText = null;
    }
  }

  public String getArticleText() {
    return this.articleText;
  }

  public PageContentItem setArticleText(String articleText) {
    this.articleText = articleText;
    return this;
  }

  public void unsetArticleText() {
    this.articleText = null;
  }

  /** Returns true if field articleText is set (has been assigned a value) and false otherwise */
  public boolean isSetArticleText() {
    return this.articleText != null;
  }

  public void setArticleTextIsSet(boolean value) {
    if (!value) {
      this.articleText = null;
    }
  }

  public String getDom() {
    return this.dom;
  }

  public PageContentItem setDom(String dom) {
    this.dom = dom;
    return this;
  }

  public void unsetDom() {
    this.dom = null;
  }

  /** Returns true if field dom is set (has been assigned a value) and false otherwise */
  public boolean isSetDom() {
    return this.dom != null;
  }

  public void setDomIsSet(boolean value) {
    if (!value) {
      this.dom = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RAW:
      if (value == null) {
        unsetRaw();
      } else {
        setRaw((ByteBuffer)value);
      }
      break;

    case FULL_TEXT:
      if (value == null) {
        unsetFullText();
      } else {
        setFullText((String)value);
      }
      break;

    case ARTICLE_TEXT:
      if (value == null) {
        unsetArticleText();
      } else {
        setArticleText((String)value);
      }
      break;

    case DOM:
      if (value == null) {
        unsetDom();
      } else {
        setDom((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RAW:
      return getRaw();

    case FULL_TEXT:
      return getFullText();

    case ARTICLE_TEXT:
      return getArticleText();

    case DOM:
      return getDom();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RAW:
      return isSetRaw();
    case FULL_TEXT:
      return isSetFullText();
    case ARTICLE_TEXT:
      return isSetArticleText();
    case DOM:
      return isSetDom();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PageContentItem)
      return this.equals((PageContentItem)that);
    return false;
  }

  public boolean equals(PageContentItem that) {
    if (that == null)
      return false;

    boolean this_present_raw = true && this.isSetRaw();
    boolean that_present_raw = true && that.isSetRaw();
    if (this_present_raw || that_present_raw) {
      if (!(this_present_raw && that_present_raw))
        return false;
      if (!this.raw.equals(that.raw))
        return false;
    }

    boolean this_present_fullText = true && this.isSetFullText();
    boolean that_present_fullText = true && that.isSetFullText();
    if (this_present_fullText || that_present_fullText) {
      if (!(this_present_fullText && that_present_fullText))
        return false;
      if (!this.fullText.equals(that.fullText))
        return false;
    }

    boolean this_present_articleText = true && this.isSetArticleText();
    boolean that_present_articleText = true && that.isSetArticleText();
    if (this_present_articleText || that_present_articleText) {
      if (!(this_present_articleText && that_present_articleText))
        return false;
      if (!this.articleText.equals(that.articleText))
        return false;
    }

    boolean this_present_dom = true && this.isSetDom();
    boolean that_present_dom = true && that.isSetDom();
    if (this_present_dom || that_present_dom) {
      if (!(this_present_dom && that_present_dom))
        return false;
      if (!this.dom.equals(that.dom))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(PageContentItem other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    PageContentItem typedOther = (PageContentItem)other;

    lastComparison = Boolean.valueOf(isSetRaw()).compareTo(typedOther.isSetRaw());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRaw()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.raw, typedOther.raw);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFullText()).compareTo(typedOther.isSetFullText());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFullText()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fullText, typedOther.fullText);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetArticleText()).compareTo(typedOther.isSetArticleText());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArticleText()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.articleText, typedOther.articleText);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDom()).compareTo(typedOther.isSetDom());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDom()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dom, typedOther.dom);
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
    StringBuilder sb = new StringBuilder("PageContentItem(");
    boolean first = true;

    if (isSetRaw()) {
      sb.append("raw:");
      if (this.raw == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.raw, sb);
      }
      first = false;
    }
    if (isSetFullText()) {
      if (!first) sb.append(", ");
      sb.append("fullText:");
      if (this.fullText == null) {
        sb.append("null");
      } else {
        sb.append(this.fullText);
      }
      first = false;
    }
    if (isSetArticleText()) {
      if (!first) sb.append(", ");
      sb.append("articleText:");
      if (this.articleText == null) {
        sb.append("null");
      } else {
        sb.append(this.articleText);
      }
      first = false;
    }
    if (isSetDom()) {
      if (!first) sb.append(", ");
      sb.append("dom:");
      if (this.dom == null) {
        sb.append("null");
      } else {
        sb.append(this.dom);
      }
      first = false;
    }
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

  private static class PageContentItemStandardSchemeFactory implements SchemeFactory {
    public PageContentItemStandardScheme getScheme() {
      return new PageContentItemStandardScheme();
    }
  }

  private static class PageContentItemStandardScheme extends StandardScheme<PageContentItem> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PageContentItem struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RAW
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.raw = iprot.readBinary();
              struct.setRawIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FULL_TEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fullText = iprot.readString();
              struct.setFullTextIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ARTICLE_TEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.articleText = iprot.readString();
              struct.setArticleTextIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DOM
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dom = iprot.readString();
              struct.setDomIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, PageContentItem struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.raw != null) {
        if (struct.isSetRaw()) {
          oprot.writeFieldBegin(RAW_FIELD_DESC);
          oprot.writeBinary(struct.raw);
          oprot.writeFieldEnd();
        }
      }
      if (struct.fullText != null) {
        if (struct.isSetFullText()) {
          oprot.writeFieldBegin(FULL_TEXT_FIELD_DESC);
          oprot.writeString(struct.fullText);
          oprot.writeFieldEnd();
        }
      }
      if (struct.articleText != null) {
        if (struct.isSetArticleText()) {
          oprot.writeFieldBegin(ARTICLE_TEXT_FIELD_DESC);
          oprot.writeString(struct.articleText);
          oprot.writeFieldEnd();
        }
      }
      if (struct.dom != null) {
        if (struct.isSetDom()) {
          oprot.writeFieldBegin(DOM_FIELD_DESC);
          oprot.writeString(struct.dom);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PageContentItemTupleSchemeFactory implements SchemeFactory {
    public PageContentItemTupleScheme getScheme() {
      return new PageContentItemTupleScheme();
    }
  }

  private static class PageContentItemTupleScheme extends TupleScheme<PageContentItem> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PageContentItem struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRaw()) {
        optionals.set(0);
      }
      if (struct.isSetFullText()) {
        optionals.set(1);
      }
      if (struct.isSetArticleText()) {
        optionals.set(2);
      }
      if (struct.isSetDom()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetRaw()) {
        oprot.writeBinary(struct.raw);
      }
      if (struct.isSetFullText()) {
        oprot.writeString(struct.fullText);
      }
      if (struct.isSetArticleText()) {
        oprot.writeString(struct.articleText);
      }
      if (struct.isSetDom()) {
        oprot.writeString(struct.dom);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PageContentItem struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.raw = iprot.readBinary();
        struct.setRawIsSet(true);
      }
      if (incoming.get(1)) {
        struct.fullText = iprot.readString();
        struct.setFullTextIsSet(true);
      }
      if (incoming.get(2)) {
        struct.articleText = iprot.readString();
        struct.setArticleTextIsSet(true);
      }
      if (incoming.get(3)) {
        struct.dom = iprot.readString();
        struct.setDomIsSet(true);
      }
    }
  }

}

