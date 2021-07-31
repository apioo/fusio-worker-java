/**
 * Autogenerated by Thrift Compiler (0.14.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.fusioproject.worker.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.2)", date = "2021-07-31")
public class Execute implements org.apache.thrift.TBase<Execute, Execute._Fields>, java.io.Serializable, Cloneable, Comparable<Execute> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Execute");

  private static final org.apache.thrift.protocol.TField ACTION_FIELD_DESC = new org.apache.thrift.protocol.TField("action", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField REQUEST_FIELD_DESC = new org.apache.thrift.protocol.TField("request", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField CONTEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("context", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ExecuteStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ExecuteTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String action; // required
  public @org.apache.thrift.annotation.Nullable Request request; // required
  public @org.apache.thrift.annotation.Nullable Context context; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ACTION((short)1, "action"),
    REQUEST((short)2, "request"),
    CONTEXT((short)3, "context");

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
        case 1: // ACTION
          return ACTION;
        case 2: // REQUEST
          return REQUEST;
        case 3: // CONTEXT
          return CONTEXT;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ACTION, new org.apache.thrift.meta_data.FieldMetaData("action", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REQUEST, new org.apache.thrift.meta_data.FieldMetaData("request", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "Request")));
    tmpMap.put(_Fields.CONTEXT, new org.apache.thrift.meta_data.FieldMetaData("context", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "Context")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Execute.class, metaDataMap);
  }

  public Execute() {
  }

  public Execute(
    java.lang.String action,
    Request request,
    Context context)
  {
    this();
    this.action = action;
    this.request = request;
    this.context = context;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Execute(Execute other) {
    if (other.isSetAction()) {
      this.action = other.action;
    }
    if (other.isSetRequest()) {
      this.request = new Request(other.request);
    }
    if (other.isSetContext()) {
      this.context = new Context(other.context);
    }
  }

  public Execute deepCopy() {
    return new Execute(this);
  }

  @Override
  public void clear() {
    this.action = null;
    this.request = null;
    this.context = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getAction() {
    return this.action;
  }

  public Execute setAction(@org.apache.thrift.annotation.Nullable java.lang.String action) {
    this.action = action;
    return this;
  }

  public void unsetAction() {
    this.action = null;
  }

  /** Returns true if field action is set (has been assigned a value) and false otherwise */
  public boolean isSetAction() {
    return this.action != null;
  }

  public void setActionIsSet(boolean value) {
    if (!value) {
      this.action = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public Request getRequest() {
    return this.request;
  }

  public Execute setRequest(@org.apache.thrift.annotation.Nullable Request request) {
    this.request = request;
    return this;
  }

  public void unsetRequest() {
    this.request = null;
  }

  /** Returns true if field request is set (has been assigned a value) and false otherwise */
  public boolean isSetRequest() {
    return this.request != null;
  }

  public void setRequestIsSet(boolean value) {
    if (!value) {
      this.request = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public Context getContext() {
    return this.context;
  }

  public Execute setContext(@org.apache.thrift.annotation.Nullable Context context) {
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

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ACTION:
      if (value == null) {
        unsetAction();
      } else {
        setAction((java.lang.String)value);
      }
      break;

    case REQUEST:
      if (value == null) {
        unsetRequest();
      } else {
        setRequest((Request)value);
      }
      break;

    case CONTEXT:
      if (value == null) {
        unsetContext();
      } else {
        setContext((Context)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ACTION:
      return getAction();

    case REQUEST:
      return getRequest();

    case CONTEXT:
      return getContext();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ACTION:
      return isSetAction();
    case REQUEST:
      return isSetRequest();
    case CONTEXT:
      return isSetContext();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof Execute)
      return this.equals((Execute)that);
    return false;
  }

  public boolean equals(Execute that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_action = true && this.isSetAction();
    boolean that_present_action = true && that.isSetAction();
    if (this_present_action || that_present_action) {
      if (!(this_present_action && that_present_action))
        return false;
      if (!this.action.equals(that.action))
        return false;
    }

    boolean this_present_request = true && this.isSetRequest();
    boolean that_present_request = true && that.isSetRequest();
    if (this_present_request || that_present_request) {
      if (!(this_present_request && that_present_request))
        return false;
      if (!this.request.equals(that.request))
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

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetAction()) ? 131071 : 524287);
    if (isSetAction())
      hashCode = hashCode * 8191 + action.hashCode();

    hashCode = hashCode * 8191 + ((isSetRequest()) ? 131071 : 524287);
    if (isSetRequest())
      hashCode = hashCode * 8191 + request.hashCode();

    hashCode = hashCode * 8191 + ((isSetContext()) ? 131071 : 524287);
    if (isSetContext())
      hashCode = hashCode * 8191 + context.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Execute other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetAction(), other.isSetAction());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAction()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.action, other.action);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetRequest(), other.isSetRequest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRequest()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.request, other.request);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetContext(), other.isSetContext());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContext()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.context, other.context);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Execute(");
    boolean first = true;

    sb.append("action:");
    if (this.action == null) {
      sb.append("null");
    } else {
      sb.append(this.action);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("request:");
    if (this.request == null) {
      sb.append("null");
    } else {
      sb.append(this.request);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("context:");
    if (this.context == null) {
      sb.append("null");
    } else {
      sb.append(this.context);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ExecuteStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ExecuteStandardScheme getScheme() {
      return new ExecuteStandardScheme();
    }
  }

  private static class ExecuteStandardScheme extends org.apache.thrift.scheme.StandardScheme<Execute> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Execute struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ACTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.action = iprot.readString();
              struct.setActionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REQUEST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.request = new Request();
              struct.request.read(iprot);
              struct.setRequestIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CONTEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.context = new Context();
              struct.context.read(iprot);
              struct.setContextIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Execute struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.action != null) {
        oprot.writeFieldBegin(ACTION_FIELD_DESC);
        oprot.writeString(struct.action);
        oprot.writeFieldEnd();
      }
      if (struct.request != null) {
        oprot.writeFieldBegin(REQUEST_FIELD_DESC);
        struct.request.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.context != null) {
        oprot.writeFieldBegin(CONTEXT_FIELD_DESC);
        struct.context.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ExecuteTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ExecuteTupleScheme getScheme() {
      return new ExecuteTupleScheme();
    }
  }

  private static class ExecuteTupleScheme extends org.apache.thrift.scheme.TupleScheme<Execute> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Execute struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetAction()) {
        optionals.set(0);
      }
      if (struct.isSetRequest()) {
        optionals.set(1);
      }
      if (struct.isSetContext()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetAction()) {
        oprot.writeString(struct.action);
      }
      if (struct.isSetRequest()) {
        struct.request.write(oprot);
      }
      if (struct.isSetContext()) {
        struct.context.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Execute struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.action = iprot.readString();
        struct.setActionIsSet(true);
      }
      if (incoming.get(1)) {
        struct.request = new Request();
        struct.request.read(iprot);
        struct.setRequestIsSet(true);
      }
      if (incoming.get(2)) {
        struct.context = new Context();
        struct.context.read(iprot);
        struct.setContextIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

