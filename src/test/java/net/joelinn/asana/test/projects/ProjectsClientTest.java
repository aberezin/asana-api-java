package net.joelinn.asana.test.projects;

import com.sun.jersey.api.client.ClientResponse;
import junit.framework.TestCase;
import net.joelinn.asana.ApiException;
import net.joelinn.asana.projects.Project;
import net.joelinn.asana.projects.ProjectRequestBuilder;
import net.joelinn.asana.projects.ProjectsClient;
import net.joelinn.asana.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Joe Linn
 * 11/20/13
 */
public class ProjectsClientTest extends BaseTest{
    protected ProjectsClient client;

    @Before
    public void setUp(){
        client = new ProjectsClient(getApiKey());
    }

    @Test
    public void testProjects(){
        if(getApiKey().equals("")){
            // skip the test if no api key has been provided
            return;
        }
        //we will use an the organization workspace because it requires a team and we want to test that too
        Project project = client.createProject(new ProjectRequestBuilder(getAsanaOrganizationId(), "test project")
                .team(getAsanaTeamId()).notes("this is a test").color("dark-blue"));

        Project retrievedProject = client.getProject(project.id);

        TestCase.assertEquals(project.name, retrievedProject.name);

        String newName = "changed the name";
        client.updateProject(retrievedProject.id, new ProjectRequestBuilder().name(newName));

        TestCase.assertEquals(newName, client.getProject(retrievedProject.id).name);

        client.deleteProject(retrievedProject.id);

        boolean exceptionThrown = false;
        try{
            client.getProject(retrievedProject.id);
        }
        catch (ApiException e){
            TestCase.assertEquals(ClientResponse.Status.NOT_FOUND.getStatusCode(), e.getStatus().getStatusCode());
            exceptionThrown = true;
        }
        TestCase.assertTrue(exceptionThrown);
    }
}
