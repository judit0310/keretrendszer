package keretrendszer.dao.impl.json;

import autosprogi.dao.AutoDAO;
import autosprogi.exceptions.RendszamMarHasznalatban;
import autosprogi.exceptions.RosszDatum;
import autosprogi.exceptions.RosszEvjarat;
import autosprogi.exceptions.RosszRendszam;
import autosprogi.model.Allapot;
import autosprogi.model.Auto;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AutoDAOJSONTest {

    @Test
    public void test() {
        AutoDAO dao = new AutoDAOJSON("src/main/resources/jsonfile.json");
        try {
            Auto auto = new Auto("Kia","Ceed","ABC-123",LocalDate.of(2019, 05, 25),100,990,5,5,14,2013,"#FFFFFF", Allapot.MEGKIMELT);
            dao.insertAuto(auto);
            System.out.println(dao.readAllAutos());
        } catch (RosszDatum rosszDatum) {
            rosszDatum.printStackTrace();
        } catch (RosszRendszam rosszRendszam) {
            rosszRendszam.printStackTrace();
        } catch (RosszEvjarat rosszEvjarat) {
            rosszEvjarat.printStackTrace();
        } catch (RendszamMarHasznalatban rendszamMarHasznalatban) {
            rendszamMarHasznalatban.printStackTrace();
        }

    }


}