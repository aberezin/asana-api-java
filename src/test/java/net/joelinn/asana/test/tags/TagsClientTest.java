package net.joelinn.asana.test.tags;

import junit.framework.TestCase;
import net.joelinn.asana.Colors;
import net.joelinn.asana.tags.Tag;
import net.joelinn.asana.tags.TagsClient;
import net.joelinn.asana.tags.TagsRequestBuilder;
import net.joelinn.asana.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Joe Linn
 * 11/20/13
 */
public class TagsClientTest extends BaseTest{
    protected TagsClient client;

    @Before
    public void setUp(){
        client = new TagsClient(getApiKey());
    }

    @Test
    public void testTags(){
        if(getApiKey().equals("")){
            // skip the test if no api key has been provided
            return;
        }
        //create tags in the organization workspace since not allowed in personal ws
        Tag tag = client.createTag(new TagsRequestBuilder(getAsanaOrganizationId(), "test tag").color(Colors.DARK_BLUE));

        Tag retrievedTag = client.getTag(tag.id);

        TestCase.assertEquals(tag.name, retrievedTag.name);

        String newColor = Colors.LIGHT_BLUE;
        client.updateTag(retrievedTag.id, new TagsRequestBuilder().color(newColor));

        TestCase.assertEquals(newColor, client.getTag(retrievedTag.id).color);
    }
}
