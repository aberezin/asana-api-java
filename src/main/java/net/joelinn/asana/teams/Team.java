package net.joelinn.asana.teams;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Joe Linn
 * 11/17/13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    public long id;
    public String name;
}
