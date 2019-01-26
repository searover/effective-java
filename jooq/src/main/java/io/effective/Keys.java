/*
 * This file is generated by jOOQ.
 */
package io.effective;


import io.effective.tables.CmsAccessKey;
import io.effective.tables.records.CmsAccessKeyRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>smartops</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CmsAccessKeyRecord, Integer> IDENTITY_CMS_ACCESS_KEY = Identities0.IDENTITY_CMS_ACCESS_KEY;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CmsAccessKeyRecord> KEY_CMS_ACCESS_KEY_PRIMARY = UniqueKeys0.KEY_CMS_ACCESS_KEY_PRIMARY;
    public static final UniqueKey<CmsAccessKeyRecord> KEY_CMS_ACCESS_KEY_SYS_CLOUD_ACCESS_ID_UINDEX = UniqueKeys0.KEY_CMS_ACCESS_KEY_SYS_CLOUD_ACCESS_ID_UINDEX;
    public static final UniqueKey<CmsAccessKeyRecord> KEY_CMS_ACCESS_KEY_CMS_ACCESS_KEY_SRN_UINDEX = UniqueKeys0.KEY_CMS_ACCESS_KEY_CMS_ACCESS_KEY_SRN_UINDEX;
    public static final UniqueKey<CmsAccessKeyRecord> KEY_CMS_ACCESS_KEY_CMS_ACCESS_KEY_ACCESS_KEY_ID_UINDEX = UniqueKeys0.KEY_CMS_ACCESS_KEY_CMS_ACCESS_KEY_ACCESS_KEY_ID_UINDEX;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<CmsAccessKeyRecord, Integer> IDENTITY_CMS_ACCESS_KEY = Internal.createIdentity(CmsAccessKey.CMS_ACCESS_KEY, CmsAccessKey.CMS_ACCESS_KEY.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<CmsAccessKeyRecord> KEY_CMS_ACCESS_KEY_PRIMARY = Internal.createUniqueKey(CmsAccessKey.CMS_ACCESS_KEY, "KEY_cms_access_key_PRIMARY", CmsAccessKey.CMS_ACCESS_KEY.ID);
        public static final UniqueKey<CmsAccessKeyRecord> KEY_CMS_ACCESS_KEY_SYS_CLOUD_ACCESS_ID_UINDEX = Internal.createUniqueKey(CmsAccessKey.CMS_ACCESS_KEY, "KEY_cms_access_key_sys_cloud_access_id_uindex", CmsAccessKey.CMS_ACCESS_KEY.ID);
        public static final UniqueKey<CmsAccessKeyRecord> KEY_CMS_ACCESS_KEY_CMS_ACCESS_KEY_SRN_UINDEX = Internal.createUniqueKey(CmsAccessKey.CMS_ACCESS_KEY, "KEY_cms_access_key_cms_access_key_srn_uindex", CmsAccessKey.CMS_ACCESS_KEY.SRN);
        public static final UniqueKey<CmsAccessKeyRecord> KEY_CMS_ACCESS_KEY_CMS_ACCESS_KEY_ACCESS_KEY_ID_UINDEX = Internal.createUniqueKey(CmsAccessKey.CMS_ACCESS_KEY, "KEY_cms_access_key_cms_access_key_access_key_id_uindex", CmsAccessKey.CMS_ACCESS_KEY.ACCESS_KEY_ID);
    }
}