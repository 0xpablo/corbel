package com.bq.oss.corbel.iam.auth.oauthserver.api;

import org.springframework.social.ApiBinding;

public interface OAuthServer extends ApiBinding {

    UserOperations userOperations();
}
