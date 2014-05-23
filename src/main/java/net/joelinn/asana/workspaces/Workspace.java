package net.joelinn.asana.workspaces;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Joe Linn
 * 11/17/13
 */
@JsonRootName("data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Workspace {
    public long id;
    public String name;
    public boolean isOrganization;  //not in api docs but returned nevertheless. But sometimes missing.
    //sometimes, email_domains=[] is returned 
}
