import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava3.core.AbstractVerticle;

public class VertxIntro extends AbstractVerticle {
    public static void main(String[] args) {
        io.vertx.core.Vertx vertx = Vertx.vertx();

        vertx.deployVerticle("HeatSensor", new DeploymentOptions().setConfig(new JsonObject().put("http-port", 3000)));
        vertx.deployVerticle("HeatSensor", new DeploymentOptions().setConfig(new JsonObject().put("http-port", 3001)));
        vertx.deployVerticle("HeatSensor", new DeploymentOptions().setConfig(new JsonObject().put("http-port", 3002)));

        vertx.deployVerticle("SnapshotService");
        vertx.deployVerticle("RxCollectorService");
    }
}
