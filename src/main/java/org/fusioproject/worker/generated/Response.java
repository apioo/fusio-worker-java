/**
 * Autogenerated by Thrift Compiler (0.14.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.fusioproject.worker.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.2)", date = "2021-07-31")
public class Response implements org.apache.thrift.TBase<Response, Response._Fields>, java.io.Serializable, Cloneable, Comparable<Response> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Response");

  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField HEADERS_FIELD_DESC = new org.apache.thrift.protocol.TField("headers", org.apache.thrift.protocol.TType.MAP, (short)2);
  private static final org.apache.thrift.protocol.TField BODY_FIELD_DESC = new org.apache.thrift.protocol.TField("body", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ResponseStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ResponseTupleSchemeFactory();

  public int statusCode; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> headers; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String body; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS_CODE((short)1, "statusCode"),
    HEADERS((short)2, "headers"),
    BODY((short)3, "body");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // STATUS_CODE
          return STATUS_CODE;
        case 2: // HEADERS
          return HEADERS;
        case 3: // BODY
          return BODY;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __STATUSCODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.HEADERS, new org.apache.thrift.meta_data.FieldMetaData("headers", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.BODY, new org.apache.thrift.meta_data.FieldMetaData("body", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Response.class, metaDataMap);
  }

  public Response() {
  }

  public Response(
    int statusCode,
    java.util.Map<java.lang.String,java.lang.String> headers,
    java.lang.String body)
  {
    this();
    this.statusCode = statusCode;
    setStatusCodeIsSet(true);
    this.headers = headers;
    this.body = body;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Response(Response other) {
    __isset_bitfield = other.__isset_bitfield;
    this.statusCode = other.statusCode;
    if (other.isSetHeaders()) {
      java.util.Map<java.lang.String,java.lang.String> __this__headers = new java.util.HashMap<java.lang.String,java.lang.String>(other.headers);
      this.headers = __this__headers;
    }
    if (other.isSetBody()) {
      this.body = other.body;
    }
  }

  public Response deepCopy() {
    return new Response(this);
  }

  @Override
  public void clear() {
    setStatusCodeIsSet(false);
    this.statusCode = 0;
    this.headers = null;
    this.body = null;
  }

  public int getStatusCode() {
    return this.statusCode;
  }

  public Response setStatusCode(int statusCode) {
    this.statusCode = statusCode;
    setStatusCodeIsSet(true);
    return this;
  }

  public void unsetStatusCode() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __STATUSCODE_ISSET_ID);
  }

  /** Returns true if field statusCode is set (has been assigned a value) and false otherwise */
  public boolean isSetStatusCode() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __STATUSCODE_ISSET_ID);
  }

  public void setStatusCodeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __STATUSCODE_ISSET_ID, value);
  }

  public int getHeadersSize() {
    return (this.headers == null) ? 0 : this.headers.size();
  }

  public void putToHeaders(java.lang.String key, java.lang.String val) {
    if (this.headers == null) {
      this.headers = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.headers.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getHeaders() {
    return this.headers;
  }

  public Response setHeaders(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> headers) {
    this.headers = headers;
    return this;
  }

  public void unsetHeaders() {
    this.headers = null;
  }

  /** Returns true if field headers is set (has been assigned a value) and false otherwise */
  public boolean isSetHeaders() {
    return this.headers != null;
  }

  public void setHeadersIsSet(boolean value) {
    if (!value) {
      this.headers = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getBody() {
    return this.body;
  }

  public Response setBody(@org.apache.thrift.annotation.Nullable java.lang.String body) {
    this.body = body;
    return this;
  }

  public void unsetBody() {
    this.body = null;
  }

  /** Returns true if field body is set (has been assigned a value) and false otherwise */
  public boolean isSetBody() {
    return this.body != null;
  }

  public void setBodyIsSet(boolean value) {
    if (!value) {
      this.body = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((java.lang.Integer)value);
      }
      break;

    case HEADERS:
      if (value == null) {
        unsetHeaders();
      } else {
        setHeaders((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    case BODY:
      if (value == null) {
        unsetBody();
      } else {
        setBody((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS_CODE:
      return getStatusCode();

    case HEADERS:
      return getHeaders();

    case BODY:
      return getBody();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case STATUS_CODE:
      return isSetStatusCode();
    case HEADERS:
      return isSetHeaders();
    case BODY:
      return isSetBody();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof Response)
      return this.equals((Response)that);
    return false;
  }

  public boolean equals(Response that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_statusCode = true;
    boolean that_present_statusCode = true;
    if (this_present_statusCode || that_present_statusCode) {
      if (!(this_present_statusCode && that_present_statusCode))
        return false;
      if (this.statusCode != that.statusCode)
        return false;
    }

    boolean this_present_headers = true && this.isSetHeaders();
    boolean that_present_headers = true && that.isSetHeaders();
    if (this_present_headers || that_present_headers) {
      if (!(this_present_headers && that_present_headers))
        return false;
      if (!this.headers.equals(that.headers))
        return false;
    }

    boolean this_present_body = true && this.isSetBody();
    boolean that_present_body = true && that.isSetBody();
    if (this_present_body || that_present_body) {
      if (!(this_present_body && that_present_body))
        return false;
      if (!this.body.equals(that.body))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + statusCode;

    hashCode = hashCode * 8191 + ((isSetHeaders()) ? 131071 : 524287);
    if (isSetHeaders())
      hashCode = hashCode * 8191 + headers.hashCode();

    hashCode = hashCode * 8191 + ((isSetBody()) ? 131071 : 524287);
    if (isSetBody())
      hashCode = hashCode * 8191 + body.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Response other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetStatusCode(), other.isSetStatusCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatusCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statusCode, other.statusCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetHeaders(), other.isSetHeaders());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHeaders()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.headers, other.headers);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetBody(), other.isSetBody());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBody()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.body, other.body);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Response(");
    boolean first = true;

    sb.append("statusCode:");
    sb.append(this.statusCode);
    first = false;
    if (!first) sb.append(", ");
    sb.append("headers:");
    if (this.headers == null) {
      sb.append("null");
    } else {
      sb.append(this.headers);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("body:");
    if (this.body == null) {
      sb.append("null");
    } else {
      sb.append(this.body);
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ResponseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResponseStandardScheme getScheme() {
      return new ResponseStandardScheme();
    }
  }

  private static class ResponseStandardScheme extends org.apache.thrift.scheme.StandardScheme<Response> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Response struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.statusCode = iprot.readI32();
              struct.setStatusCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HEADERS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map72 = iprot.readMapBegin();
                struct.headers = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map72.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key73;
                @org.apache.thrift.annotation.Nullable java.lang.String _val74;
                for (int _i75 = 0; _i75 < _map72.size; ++_i75)
                {
                  _key73 = iprot.readString();
                  _val74 = iprot.readString();
                  struct.headers.put(_key73, _val74);
                }
                iprot.readMapEnd();
              }
              struct.setHeadersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BODY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.body = iprot.readString();
              struct.setBodyIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Response struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(STATUS_CODE_FIELD_DESC);
      oprot.writeI32(struct.statusCode);
      oprot.writeFieldEnd();
      if (struct.headers != null) {
        oprot.writeFieldBegin(HEADERS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.headers.size()));
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter76 : struct.headers.entrySet())
          {
            oprot.writeString(_iter76.getKey());
            oprot.writeString(_iter76.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.body != null) {
        oprot.writeFieldBegin(BODY_FIELD_DESC);
        oprot.writeString(struct.body);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ResponseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResponseTupleScheme getScheme() {
      return new ResponseTupleScheme();
    }
  }

  private static class ResponseTupleScheme extends org.apache.thrift.scheme.TupleScheme<Response> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Response struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStatusCode()) {
        optionals.set(0);
      }
      if (struct.isSetHeaders()) {
        optionals.set(1);
      }
      if (struct.isSetBody()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetStatusCode()) {
        oprot.writeI32(struct.statusCode);
      }
      if (struct.isSetHeaders()) {
        {
          oprot.writeI32(struct.headers.size());
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter77 : struct.headers.entrySet())
          {
            oprot.writeString(_iter77.getKey());
            oprot.writeString(_iter77.getValue());
          }
        }
      }
      if (struct.isSetBody()) {
        oprot.writeString(struct.body);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Response struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.statusCode = iprot.readI32();
        struct.setStatusCodeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map78 = iprot.readMapBegin(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING); 
          struct.headers = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map78.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _key79;
          @org.apache.thrift.annotation.Nullable java.lang.String _val80;
          for (int _i81 = 0; _i81 < _map78.size; ++_i81)
          {
            _key79 = iprot.readString();
            _val80 = iprot.readString();
            struct.headers.put(_key79, _val80);
          }
        }
        struct.setHeadersIsSet(true);
      }
      if (incoming.get(2)) {
        struct.body = iprot.readString();
        struct.setBodyIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

