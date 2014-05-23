package net.joelinn.asana.test.workspaces;

import net.joelinn.asana.test.BaseTest;
import net.joelinn.asana.workspaces.Workspace;
import net.joelinn.asana.workspaces.Workspaces;
import net.joelinn.asana.workspaces.WorkspacesClient;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Joe Linn
 * 11/17/13
 */
public class WorkspacesClientTest extends BaseTest{
    protected WorkspacesClient client;

    @Before
    public void setUp(){
        client = new WorkspacesClient(getApiKey());
    }

    @Test
    public void testGetWorkspaces(){
        if(getApiKey().equals("")){
            // skip the test if no api key has been provided
            return;
        }
        Workspaces workspaces = client.getWorkspaces();
        for(Workspace ws: workspaces) {
            System.out.println(ws.name + ": isOrg:" + ws.isOrganization +" : "  + ws.id);
        }
    }

    /**
     * Seems cannot rename a workspace that is an organization (makes sense) nor a personal workspace.
     * Maybe paid-for orgs can have mutiple ws which can be renamed
     */
    @Ignore("Renaming workspaces seems problimatic.")
    @Test
    public void testUpdateWorkspace(){
        if(getApiKey().equals("")){
            // skip the test if no api key has been provided
            return;
        }
        for(Workspace ws: client.getWorkspaces()) {
        	if (ws.id == getAsanaWorkspaceId()) {
        		String oldName = ws.name;
                client.updateWorkspace(getAsanaWorkspaceId(), "testcase renamed");
                client.updateWorkspace(getAsanaWorkspaceId(), oldName);        		
        	}
        }
    }
    
}
