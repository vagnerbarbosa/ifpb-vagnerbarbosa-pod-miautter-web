import org.glassfish.embeddable.*;
import org.glassfish.embeddable.archive.*;
import java.io.*;

public class App {
  
  public static void main(String[] args) throws Exception{
    //para capturar a porta do heroku
    String port = System.getenv("PORT");
    if (port == null || port.isEmpty()) {
      port = "8080";
    }
    //instanciando o glassfish embedded
    GlassFishProperties glassfishProperties = new GlassFishProperties();
    glassfishProperties.setPort("http-listener", Integer.parseInt(port));

    GlassFish glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
    glassfish.start();

    Deployer deployer = glassfish.getDeployer();
    ScatteredArchive archive = new ScatteredArchive("webapp", ScatteredArchive.Type.WAR, new File("src/main/webapp/"));
    archive.addClassPath(new File("target", "classes"));
    deployer.deploy(archive.toURI());
  }

}

