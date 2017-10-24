/**
 * Copyright (c) 2017 Contributors to the Eclipse Foundation
 * Copyright 2017 SmartBear Software
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.microprofile.openapi.annotations.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Defines a security scheme that can be used by the operations. 
 * Supported schemes are HTTP authentication, an API key (either as a header or as a query parameter), OAuth2's common flows (implicit, password, application and access code) as defined in RFC6749, and OpenID Connect Discovery.
 **/
@Target({ ElementType.METHOD,
        ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SecurityScheme {
  /**
   * Type is a REQUIRED property that specifies the type of SecurityScheme instance.
	 * <p>
   * The type of the security scheme. Valid values are "apiKey", "http", "oauth2", "openIdConnect".
   **/
  String type();

  /**
   * A short description for security scheme. CommonMark syntax can be used for rich text representation.
   **/
  String description() default "";

  /**
   * Name is a REQUIRED property for apiKey type. It is the name of the header, query or cookie parameter to be used.
   * Applies to apiKey type.
   **/
  String name() default "";

  /**
   * The location of the API key. Valid values are "query" or "header". 
   * A REQUIRED property for apiKey type.
   **/
  String in() default "";

  /**
   * The name of the HTTP Authorization scheme to be used in the Authorization header as defined in RFC 7235.  
   * A REQUIRED property for http type.
   **/
  String scheme() default "";

  /**
   * A hint to the client to identify how the bearer token is formatted. 
   * Bearer tokens are usually generated by an authorization server, so this information is primarily for documentation purposes.  
   * Applies to http ("bearer") type.
   **/
  String bearerFormat() default "";

  /**
   * This is a REQUIRED property for oauth2 type.
   * An object containing configuration information for the flow types supported.  
   **/
  OAuthFlows flows() default @OAuthFlows;

  /**
   * This is a REQUIRED property for openIdConnect type.
   * OpenId Connect URL to discover OAuth2 configuration values. 
   * This MUST be in the form of a URL.
   **/
  String openIdConnectUrl() default "";

}