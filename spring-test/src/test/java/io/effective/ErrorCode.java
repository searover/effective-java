package io.effective;

/**
 * 全局错误码，对应 resource bundle properties，用于 i18n
 */
public enum ErrorCode {
    login_name_not_found,        // 用户名不存在
    login_email_error,        // 邮箱不存在或不是主账号邮箱
    login_account_deleted,        // 客户已删除
    login_error,                // 用户名或密码错误，登录失败
    login_required,             // 用户未登录或登录状态已过期
    user_not_found,             // 用户不存在
    user_not_ops,
    user_email_exist,
    user_mobile_exist,
    user_delete_deny_for_root,  // 根用户不可删除
    user_exist_in_group,  //
    user_not_exist_in_group,  //
    account_name_exist,         // 客户名称已存在
    account_not_found,
    group_name_exist,
    group_not_found,
    policy_not_found,
    policy_attached,
    policy_not_attached,
    policy_update_error,
    token_error,
    params_error(2),
    param_is_required(1),
    resource_not_found,         // 请求的资源不存在
    resource_access_denied,
    action_denied,
    sms_code_error,             // 短信验证码不正确
    note_not_found,
    server_unexpect_error,
    ;

    private int holderCount;

    ErrorCode() {
        this.holderCount = 0;
    }

    ErrorCode(int holderCount) {
        this.holderCount = holderCount;
    }}