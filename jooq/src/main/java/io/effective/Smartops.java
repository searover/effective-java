/*
 * This file is generated by jOOQ.
 */
package io.effective;


import io.effective.tables.CmsAccessKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Smartops extends SchemaImpl {

    private static final long serialVersionUID = -1702954751;

    /**
     * The reference instance of <code>smartops</code>
     */
    public static final Smartops SMARTOPS = new Smartops();

    /**
     * The table <code>smartops.cms_access_key</code>.
     */
    public final CmsAccessKey CMS_ACCESS_KEY = io.effective.tables.CmsAccessKey.CMS_ACCESS_KEY;

    /**
     * No further instances allowed
     */
    private Smartops() {
        super("smartops", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            CmsAccessKey.CMS_ACCESS_KEY);
    }
}
