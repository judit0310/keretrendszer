package autosprogi.model;

import autosprogi.exceptions.RosszRendszam;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.Collection;

public class AutoTest {

    @Test
    public void testSetRendszam() {
        String rendszam="ABC-123";
        Auto auto = new Auto();
        try {
            auto.setRendszam(rendszam);
        } catch (RosszRendszam rosszRendszam) {
            rosszRendszam.printStackTrace();
        }
    }

    @Test(expected = RosszRendszam.class)
    public void testSetRendszamWithBadParameter() throws RosszRendszam {
        String rendszam="AC-123";
        Auto auto = new Auto();
        auto.setRendszam(rendszam);

    }

    @Test
    public void testDB() throws UnknownHostException {
        String uri =
                "mongodb+srv://proba:proba@ora-hypby.mongodb.net/test?retryWrites=true&w=majority";

        MongoClient mongoClient = new com.mongodb.MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("adatbazis");
        System.out.println(database.getName());
        MongoCollection<Document> autok = database.getCollection("autok");
        Document ujauto= new Document();
        ujauto.append("rendszam","abc-123");
        autok.insertOne(ujauto);


    }
}