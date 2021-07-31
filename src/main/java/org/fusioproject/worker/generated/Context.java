/**
 * Autogenerated by Thrift Compiler (0.14.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.fusioproject.worker.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.2)", date = "2021-07-31")
public class Context implements org.apache.thrift.TBase<Context, Context._Fields>, java.io.Serializable, Cloneable, Comparable<Context> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Context");

  private static final org.apache.thrift.protocol.TField ROUTE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("routeId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField BASE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("baseUrl", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField APP_FIELD_DESC = new org.apache.thrift.protocol.TField("app", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField USER_FIELD_DESC = new org.apache.thrift.protocol.TField("user", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ContextStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ContextTupleSchemeFactory();

  public long routeId; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String baseUrl; // required
  public @org.apache.thrift.annotation.Nullable App app; // required
  public @org.apache.thrift.annotation.Nullable User user; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ROUTE_ID((short)1, "routeId"),
    BASE_URL((short)2, "baseUrl"),
    APP((short)3, "app"),
    USER((short)4, "user");

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
        case 1: // ROUTE_ID
          return ROUTE_ID;
        case 2: // BASE_URL
          return BASE_URL;
        case 3: // APP
          return APP;
        case 4: // USER
          return USER;
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
  private static final int __ROUTEID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROUTE_ID, new org.apache.thrift.meta_data.FieldMetaData("routeId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.BASE_URL, new org.apache.thrift.meta_data.FieldMetaData("baseUrl", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.APP, new org.apache.thrift.meta_data.FieldMetaData("app", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "App")));
    tmpMap.put(_Fields.USER, new org.apache.thrift.meta_data.FieldMetaData("user", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "User")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Context.class, metaDataMap);
  }

  public Context() {
  }

  public Context(
    long routeId,
    java.lang.String baseUrl,
    App app,
    User user)
  {
    this();
    this.routeId = routeId;
    setRouteIdIsSet(true);
    this.baseUrl = baseUrl;
    this.app = app;
    this.user = user;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Context(Context other) {
    __isset_bitfield = other.__isset_bitfield;
    this.routeId = other.routeId;
    if (other.isSetBaseUrl()) {
      this.baseUrl = other.baseUrl;
    }
    if (other.isSetApp()) {
      this.app = new App(other.app);
    }
    if (other.isSetUser()) {
      this.user = new User(other.user);
    }
  }

  public Context deepCopy() {
    return new Context(this);
  }

  @Override
  public void clear() {
    setRouteIdIsSet(false);
    this.routeId = 0;
    this.baseUrl = null;
    this.app = null;
    this.user = null;
  }

  public long getRouteId() {
    return this.routeId;
  }

  public Context setRouteId(long routeId) {
    this.routeId = routeId;
    setRouteIdIsSet(true);
    return this;
  }

  public void unsetRouteId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ROUTEID_ISSET_ID);
  }

  /** Returns true if field routeId is set (has been assigned a value) and false otherwise */
  public boolean isSetRouteId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ROUTEID_ISSET_ID);
  }

  public void setRouteIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ROUTEID_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getBaseUrl() {
    return this.baseUrl;
  }

  public Context setBaseUrl(@org.apache.thrift.annotation.Nullable java.lang.String baseUrl) {
    this.baseUrl = baseUrl;
    return this;
  }

  public void unsetBaseUrl() {
    this.baseUrl = null;
  }

  /** Returns true if field baseUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetBaseUrl() {
    return this.baseUrl != null;
  }

  public void setBaseUrlIsSet(boolean value) {
    if (!value) {
      this.baseUrl = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public App getApp() {
    return this.app;
  }

  public Context setApp(@org.apache.thrift.annotation.Nullable App app) {
    this.app = app;
    return this;
  }

  public void unsetApp() {
    this.app = null;
  }

  /** Returns true if field app is set (has been assigned a value) and false otherwise */
  public boolean isSetApp() {
    return this.app != null;
  }

  public void setAppIsSet(boolean value) {
    if (!value) {
      this.app = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public User getUser() {
    return this.user;
  }

  public Context setUser(@org.apache.thrift.annotation.Nullable User user) {
    this.user = user;
    return this;
  }

  public void unsetUser() {
    this.user = null;
  }

  /** Returns true if field user is set (has been assigned a value) and false otherwise */
  public boolean isSetUser() {
    return this.user != null;
  }

  public void setUserIsSet(boolean value) {
    if (!value) {
      this.user = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ROUTE_ID:
      if (value == null) {
        unsetRouteId();
      } else {
        setRouteId((java.lang.Long)value);
      }
      break;

    case BASE_URL:
      if (value == null) {
        unsetBaseUrl();
      } else {
        setBaseUrl((java.lang.String)value);
      }
      break;

    case APP:
      if (value == null) {
        unsetApp();
      } else {
        setApp((App)value);
      }
      break;

    case USER:
      if (value == null) {
        unsetUser();
      } else {
        setUser((User)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ROUTE_ID:
      return getRouteId();

    case BASE_URL:
      return getBaseUrl();

    case APP:
      return getApp();

    case USER:
      return getUser();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ROUTE_ID:
      return isSetRouteId();
    case BASE_URL:
      return isSetBaseUrl();
    case APP:
      return isSetApp();
    case USER:
      return isSetUser();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof Context)
      return this.equals((Context)that);
    return false;
  }

  public boolean equals(Context that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_routeId = true;
    boolean that_present_routeId = true;
    if (this_present_routeId || that_present_routeId) {
      if (!(this_present_routeId && that_present_routeId))
        return false;
      if (this.routeId != that.routeId)
        return false;
    }

    boolean this_present_baseUrl = true && this.isSetBaseUrl();
    boolean that_present_baseUrl = true && that.isSetBaseUrl();
    if (this_present_baseUrl || that_present_baseUrl) {
      if (!(this_present_baseUrl && that_present_baseUrl))
        return false;
      if (!this.baseUrl.equals(that.baseUrl))
        return false;
    }

    boolean this_present_app = true && this.isSetApp();
    boolean that_present_app = true && that.isSetApp();
    if (this_present_app || that_present_app) {
      if (!(this_present_app && that_present_app))
        return false;
      if (!this.app.equals(that.app))
        return false;
    }

    boolean this_present_user = true && this.isSetUser();
    boolean that_present_user = true && that.isSetUser();
    if (this_present_user || that_present_user) {
      if (!(this_present_user && that_present_user))
        return false;
      if (!this.user.equals(that.user))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(routeId);

    hashCode = hashCode * 8191 + ((isSetBaseUrl()) ? 131071 : 524287);
    if (isSetBaseUrl())
      hashCode = hashCode * 8191 + baseUrl.hashCode();

    hashCode = hashCode * 8191 + ((isSetApp()) ? 131071 : 524287);
    if (isSetApp())
      hashCode = hashCode * 8191 + app.hashCode();

    hashCode = hashCode * 8191 + ((isSetUser()) ? 131071 : 524287);
    if (isSetUser())
      hashCode = hashCode * 8191 + user.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Context other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetRouteId(), other.isSetRouteId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRouteId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.routeId, other.routeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetBaseUrl(), other.isSetBaseUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBaseUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.baseUrl, other.baseUrl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetApp(), other.isSetApp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.app, other.app);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetUser(), other.isSetUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user, other.user);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Context(");
    boolean first = true;

    sb.append("routeId:");
    sb.append(this.routeId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("baseUrl:");
    if (this.baseUrl == null) {
      sb.append("null");
    } else {
      sb.append(this.baseUrl);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("app:");
    if (this.app == null) {
      sb.append("null");
    } else {
      sb.append(this.app);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("user:");
    if (this.user == null) {
      sb.append("null");
    } else {
      sb.append(this.user);
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

  private static class ContextStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ContextStandardScheme getScheme() {
      return new ContextStandardScheme();
    }
  }

  private static class ContextStandardScheme extends org.apache.thrift.scheme.StandardScheme<Context> {

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
          case 1: // ROUTE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.routeId = iprot.readI64();
              struct.setRouteIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BASE_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.baseUrl = iprot.readString();
              struct.setBaseUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // APP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.app = new App();
              struct.app.read(iprot);
              struct.setAppIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.user = new User();
              struct.user.read(iprot);
              struct.setUserIsSet(true);
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
      oprot.writeFieldBegin(ROUTE_ID_FIELD_DESC);
      oprot.writeI64(struct.routeId);
      oprot.writeFieldEnd();
      if (struct.baseUrl != null) {
        oprot.writeFieldBegin(BASE_URL_FIELD_DESC);
        oprot.writeString(struct.baseUrl);
        oprot.writeFieldEnd();
      }
      if (struct.app != null) {
        oprot.writeFieldBegin(APP_FIELD_DESC);
        struct.app.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.user != null) {
        oprot.writeFieldBegin(USER_FIELD_DESC);
        struct.user.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ContextTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ContextTupleScheme getScheme() {
      return new ContextTupleScheme();
    }
  }

  private static class ContextTupleScheme extends org.apache.thrift.scheme.TupleScheme<Context> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Context struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetRouteId()) {
        optionals.set(0);
      }
      if (struct.isSetBaseUrl()) {
        optionals.set(1);
      }
      if (struct.isSetApp()) {
        optionals.set(2);
      }
      if (struct.isSetUser()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetRouteId()) {
        oprot.writeI64(struct.routeId);
      }
      if (struct.isSetBaseUrl()) {
        oprot.writeString(struct.baseUrl);
      }
      if (struct.isSetApp()) {
        struct.app.write(oprot);
      }
      if (struct.isSetUser()) {
        struct.user.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Context struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.routeId = iprot.readI64();
        struct.setRouteIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.baseUrl = iprot.readString();
        struct.setBaseUrlIsSet(true);
      }
      if (incoming.get(2)) {
        struct.app = new App();
        struct.app.read(iprot);
        struct.setAppIsSet(true);
      }
      if (incoming.get(3)) {
        struct.user = new User();
        struct.user.read(iprot);
        struct.setUserIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
