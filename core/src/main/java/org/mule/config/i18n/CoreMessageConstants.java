/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the MuleSource MPL
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.config.i18n;

/**
 * <code>CoreMessageConstants</code> contains contants for all Mule core exception
 * messages and other strings.
 */
public interface CoreMessageConstants
{
    int VERSION_INFO_NOT_SET = 1;
    int SERVER_STARTED_AT_X = 2;
    int SERVER_SHUTDOWN_AT_X = 3;
    int AGENTS_RUNNING = 4;
    int NOT_SET = 5;
    int VERSION = 6;
    int SHUTDOWN_NORMALLY_ON_X = 7;
    int SERVER_WAS_UP_FOR_X = 8;
    int CONFIG_NOT_FOUND_USAGE = 9;
    int FATAL_ERROR_WHILE_RUNNING = 10;
    int ROOT_STACK_TRACE = 11;
    int EXCEPTION_STACK_IS = 12;
    int FOR_MORE_INFO_EXCEPTION = 13;
    int FOR_MORE_INFO = 14;
    int JAVADOC_REF = 15;
    int DOC_REF = 16;
    int SEE_EXCEPTION_BELOW = 17;
    int MESSAGE_IS_OF_TYPE_X = 18;
    int MESSAGE_DETAILS = 19;
    int FATAL_ERROR_SHUTDOWN = 20;
    int NORMAL_SHUTDOWN = 21;
    int NONE = 22;
    int NOT_CLUSTERED = 23;

    int FAILED_TO_ROUTER_VIA_ENDPOINT = 30;
    int NO_COMPONENT_FOR_LOCAL_REFERENCE = 31;
    int CANT_USE_DISPOSED_CONNECTOR = 32;
    int CONNECTOR_CAUSED_ERROR = 33;
    int ENDPOINT_NULL_FOR_LISTENER = 34;
    int LISTENER_ALREADY_REGISTERED = 35;
    int CONNECTOR_NOT_STARTED = 36;
    int OBJECT_X_ALREADY_INITIALISED = 37;
    int COMPONENT_CAUSED_ERROR_IS_X = 38;
    int OBJECT_CAUSED_ERROR_IS_X = 39;
    int X_FAILED_TO_INITIALISE = 40;
    int FAILED_TO_STOP_X = 41;
    int FAILED_TO_START_X = 42;
    int PROXY_POOL_TIMED_OUT = 43;
    int FAILED_TO_GET_POOLED_OBJECT = 44;
    int X_IS_NULL = 45;
    int COMPONENT_X_NOT_REGISTERED = 46;
    int FAILED_TO_REGISTER_X_ON_ENDPOINT_X = 47;
    int FAILED_TO_UNREGISTER_X_ON_ENDPOINT_X = 48;
    int FAILED_TO_PAUSE_X = 49;
    int FAILED_TO_RESUME_X = 50;
    int ENPOINT_X_IS_MALFORMED = 51;
    int TRANSFORM_FAILED_BEFORE_FILTER = 52;
    int TRANSFORM_X_UNEXPECTED_TYPE_X = 53;
    int TRANSFORM_X_UNSUPORTED_TYPE_X_ENDPOINT_X = 54;
    int TRANSFORM_FAILED_FROM_X = 55;
    int ENCRYPT_STRATEGY_NOT_SET = 56;
    int FAILED_LOAD_X_TRANSFORMER_X = 57;
    int FAILED_LOAD_X = 58;
    int MESSAGE_X_NOT_SUPPORTED_BY_ADAPTER_X = 59;
    int TOO_MANY_ENTRY_POINTS_ON_X = 60;
    int CANT_SET_PROP_X_ON_X_OF_TYPE_X = 61;
    int NO_SESSION_FOR_COMPONENT_X = 62;
    int NO_ENDPOINT_X_FOR_COMPONENT_X = 63;
    int NO_COMPONENT_FOR_ENDPOINT = 64;
    int FAILED_TO_CREATE_X = 65;
    int NO_CORRELATION_ID = 66;
    int FAILED_TO_DISPOSE_X = 67;
    int FAILED_TO_INVOKE_X = 68;
    int CANT_READ_PAYLOAD_AS_BYTES_TYPE_IS_X = 69;
    int CANT_READ_PAYLOAD_AS_STRING_TYPE_IS_X = 70;
    int CLASS_X_NOT_FOUND = 71;
    int COMPONENT_X_ROUTING_FAILED_ON_ENDPOINT_X = 72;
    int CANT_INSTANCIATE_FINDER_X = 73;
    int FAILED_TO_CREATE_X_WITH_X = 74;
    int X_NOT_SET_IN_SERVICE_X = 75;
    int OBJECT_NOT_FOUND_X = 76;
    int TX_MARKED_FOR_ROLLBACK = 77;
    int TX_CANT_BIND_TO_NULL_KEY = 78;
    int TX_CANT_BIND_NULL_RESOURCE = 79;
    int TX_SINGLE_RESOURCE_ONLY = 80;
    int NO_CURRENT_EVENT_FOR_TRANSFORMER = 81;
    int X_NOT_REGISTERED_WITH_MANAGER = 82;
    int FAILED_TO_SET_PROPERTIES_ON_X = 83;
    int FAILED_TO_CREATE_CONNECTOR_FROM_URI_X = 84;
    int INITIALISATION_FAILURE_X = 85;
    int FAILED_TO_INITIALISE_INTERCEPTORS_ON_X = 86;
    int FAILED_TO_ENDPOINT_FROM_LOCATION_X = 87;
    int MANAGER_ALREADY_STARTED = 88;
    int NO_ENDPOINTS_FOR_ROUTER = 89;
    int RESPONSE_TIMED_OUT_X_WAITING_FOR_ID_X = 90;
    int NO_LOCAL_IMPL_X_SET_ON_DESCRIPTOR_X = 91;
    int CANT_INSTANCIATE_NON_CONTAINER_REF_X = 92;
    int FAILED_TO_RECEIVE_OVER_X_TIMEOUT_X = 93;
    int FAILED_TO_WRITE_X_TO_STORE_X = 94;
    int FAILED_TO_READ_FROM_STORE_X = 95;
    int TX_CANT_START_X_TRANSACTION = 96;
    int TX_COMMIT_FAILED = 97;
    int TX_ROLLBACK_FAILED = 98;
    int TX_CANT_READ_STATE = 99;
    int TX_RESOURCE_ALREADY_LISTED_FOR_KEY_X = 100;
    int NO_OUTBOUND_ROUTER_SET_ON_X = 101;
    int CANT_SET_PROPERTY_X_ON_X = 102;
    int TX_AVAILABLE_BUT_ACTION_IS_X = 103;
    int TX_NOT_AVAILABLE_BUT_ACTION_IS_X = 104;
    int NO_CATCH_ALL_ENDPOINT_SET = 105;
    int INTERRUPTED_QUEUING_EVENT_FOR_X = 106;
    int TX_CANT_UNBIND = 107;
    int TX_CANT_BIND_ALREADY_BOUND = 108;
    int METHOD_X_WITH_PARAMS_X_NOT_FOUND_ON_X = 109;
    int TRANSFORM_FAILED_FROM_X_TO_X = 110;
    int EVENT_PROPERTY_X_NOT_SET_CANT_PROCESS_REQUEST = 111;
    int CRYPTO_FAILURE = 112;
    int JMX_CREATE_OR_LOCATE_SHOULD_BE_SET = 113;
    int JMX_CANT_LOCATE_CREATE_SERVER = 114;
    int SCHEME_X_NOT_COMPATIBLE_WITH_CONNECTOR_X = 115;
    int NO_ENTRY_POINT_FOUND_ON_X_WITH_ARGS_X = 116;
    int AUTH_NO_SECURITY_PROVIDER_X = 117;
    int NO_RECEIVER_X_FOR_ENDPOINT_X = 118;
    int TX_SET_AUTO_COMMIT_FAILED = 119;
    int TX_CAN_ONLY_BIND_TO_X_TYPE_RESOURCES = 120;
    int JNDI_RESOURCE_X_NOT_FOUND = 121;
    int CANT_LOAD_X_FROM_CLASSPATH_FILE = 122;
    int FAILED_TO_CONFIGURE_CONTAINER = 123;
    int FAILED_TO_READ_PAYLOAD = 124;
    int MESSAGE_NOT_X_IT_IS_TYPE_X_CHECK_TRANSFORMER_ON_X = 125;
    int ENDPOINT_X_NOT_FOUND = 126;
    int EVENT_PROCESSING_FAILED_FOR_X = 127;
    int FAILED_TO_DISPATCH_TO_REPLYTO_X = 128;
    int ROUTING_ERROR = 129;
    int CRYPTO_STRATEGY_IS = 130;
    int AUTH_TYPE_NOT_RECOGNISED = 131;
    int AUTH_SECURITY_MANAGER_NOT_SET = 132;
    int AUTH_SET_TO_X_BUT_NO_CONTEXT = 133;
    int AUTH_DENIED_ON_ENDPOINT_X = 134;
    int AUTH_FAILED_FOR_USER_X = 135;
    int AUTH_ENDPOINT_TYPE_FOR_FILTER_MUST_BE_X_BUT_IS_X = 136;
    int AUTH_NO_PROVIDER_REGISTERED_FOR = 137;
    int AUTH_REALM_MUST_SET_ON_FILTER = 138;
    int FAILED_TO_PARSE_CONFIG_RESOURCE_X = 139;
    int TX_MANAGER_ALREADY_SET = 140;
    int COULD_NOT_RECOVER_CONTIANER_CONFIG = 141;
    int ONLY_SINGLE_RESOURCE_CAN_BE_SPECIFIED = 142;
    int ONLY_CUSTOM_EVENTS_CAN_BE_FIRED = 143;
    int FAILED_TO_CREATE_MANAGER_INSTANCE_X = 144;
    int FAILED_TO_CLONE_X = 145;
    int EXCEPTION_ON_CONNECTOR_X_NO_EXCEPTION_LISTENER = 146;
    int UNIQUE_ID_NOT_SUPPORTED_BY_ADAPTER_X = 147;
    int FAILED_TO_PERSIST_EVENT_X = 148;
    int FILE_X_DOES_NOT_EXIST = 149;
    int SERVER_EVENT_MANAGER_NOT_ENABLED = 150;
    int FAILED_TO_SCHEDULE_WORK = 151;
    int AUTH_NO_CREDENTIALS = 152;
    int X_IS_DISPOSED = 153;
    int VALUE_X_IS_INVALID_FOR_X = 154;
    int CONTAINER_X_ALREADY_REGISTERED = 155;
    int CONNECTOR_WITH_PROTOCOL_X_NOT_REGISTERED = 156;
    int PROPERTY_X_IS_NOT_SUPPORTED_TYPE_X_IT_IS_TYPE_X = 157;
    int PROPERTY_TEMPLATE_MALFORMED_X = 158;
    int MANAGER_IS_ALREADY_CONFIGURED = 159;
    int X_MUST_IMPLEMENT_AN_INTERFACE = 160;

    int RESOURCE_MANAGER_NOT_STARTED = 161;
    int RESOURCE_MANAGER_DIRTY = 162;
    int RESOURCE_MANAGER_NOT_READY = 163;

    int RECONNECT_STRATEGY_X_FAILED_ENDPOINT_X = 164;
    int CANT_SET_X_ONCE_IT_HAS_BEEN_SET = 165;
    int EVENT_TYPE_X_NOT_RECOGNISED = 166;

    int COMPONENT_X_IS_STOPPED = 167;
    int X_PROPERTY_IS_NOT_SET_ON_EVENT = 168;
    int EJB_OBJECT_X_MISSING_CREATE = 169;
    int EJB_KEY_REF_X_NOT_VALID = 170;
    int DESCRIPTOR_X_ALREADY_EXISTS = 171;
    int FAILED_TO_INVOKE_REST_SERVICE_X = 172;
    int MUST_SPECIFY_REF_ATTRIB_X_OR_CLASS_ATTRIB_X_FOR_X = 173;
    int AUTH_NO_ENCRYPTION_STRATEGY_X = 174;
    int HEADER_X_MALFORMED_VALUE_IS_X = 175;
    int TX_MANAGER_NOT_SET = 176;
    int TRANSFORM_ON_X_NOT_OF_SPECIFIED_TYPE_X = 177;
    int CANNOT_USE_TX_AND_REMOTE_SYNC = 178;
    int CANNOT_BIND_TO_ADDRESS_X = 179;
    int FAILED_TO_BUILD_MESSAGE = 180;
    int NO_MATCHING_METHODS_FOR_X_ON_X = 181;
    int TOO_MANY_MATCHING_METHODS_FOR_X_ON_X = 182;
    int PROPERTIES_X_NOT_SET = 183;
    int SCRIPT_ENGINE_MUST_BE_COMPILABLE = 184;
    int OBJECT_X_NOT_OF_CORRECT_TYPE_SHOULD_BE_X = 185;
    int OBJECT_X_MARKED_INVALID = 186;
    int SYSTEM_PROPERTY_X_NOT_SET = 187;
    int FAILED_TO_CONVERT_STRING_USING_X_ENCODING = 188;
    int PROPERTY_X_HAS_INVALID_VALUE_X = 189;

    // Post 1.2 message
    int SPACE_ACTION_X_INTERRUPTED = 190;
    int SPACE_FAILED_TO_CREATE = 191;
    int SCHEME_CANT_CHANGE_FOR_ROUTER_X_X = 192;
    int DAYS = 193;
    int HOURS = 194;
    int MINS = 195;
    int SEC = 196;

    // Post mule_1_3 branch merge
    int TEMPLATE_X_CAUSED_MALFORMED_ENDPOINT_X = 197;
    int COULD_NOT_DETERMINE_DESTINATION_COMPONENT_FROM_ENDPOINT_X = 198;
    int COULD_NOT_FIND_SOAP_PROVIDER_X = 199;
    int TX_NO_CURRENT_TRANSACTION = 200;
    int SESSION_VALUE_X_IS_MALFORMED = 201;

    // post Mule 1.3-rc1
    int ROUTER_CAN_ONLY_HAVE_ONE_ENDPOINT = 202;
    int ENDPOINT_X_IS_NOT_STREAMING = 203;
    int ENDPOINT_X_DOES_NOT_SUPPORT_STREAMING = 204;
    int STREAMING_FAILED_NO_STREAM = 205;
    int CONNECTOR_SCHEME_X_INCOMPATIBLE_WITH_ENDPOINT_SCHEME_X = 206;
    int FAILED_TO_READ_ATTACHMENT_X = 207;

    // post Mule 1.3-rc2
    int FAILED_TO_INITIALIZE_SECURITY_PROVIDER = 208;
}
