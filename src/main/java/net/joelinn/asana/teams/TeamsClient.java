package net.joelinn.asana.teams;

import net.joelinn.asana.AbstractClient;

/**
 * Joe Linn
 * 11/17/13
 * @see <a href="http://developer.asana.com/documentation/#teams">http://developer.asana.com/documentation/#teams</a>
 */
public class TeamsClient extends AbstractClient{
    public TeamsClient(String apiKey) {
        super(apiKey);
    }

    /**
     * Retrieve all teams of which the current user is a member within the given organization
     * @param organizationId an organization id
     * @return a list of Team objects
     */
    public Teams getTeams(long organizationId){
        return get(String.format("organizations/%s/teams", organizationId)).getEntity(Teams.class);
    }
}
