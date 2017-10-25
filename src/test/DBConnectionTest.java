package test;

import static org.junit.Assert.*;

import org.junit.Test;

import persistencia.DBConnector;

public class DBConnectionTest
{

	@Test
	public void pruebaConectar()
	{
		DBConnector.getInstancia();
	}

}
