package com.otis.LOTRDrp.Servers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LOTRDrpServers {
public static ISupportedServer TOS = new ISupportedServer() {
	@Override
	public String name() {
		return "LOTR Mod: Official Server";
	}
	@Override
	public String ip() {

		return "lotr.g.akliz.net";
	}
	@Override
	public String iconName() {
		return "tos";
	}
};
public static ISupportedServer LOTRSurvival = new ISupportedServer() {
	@Override
	public String name() {
		return "LOTR Survival";
	}
	@Override
	public String ip() {

		return "lotr.mine.bz";
	}
	@Override
	public String iconName() {
		return "serv";
	}
};	
public static ISupportedServer TheRingOfPower = new ISupportedServer() {
	@Override
	public String name() {
		return "The Ring of Power";
	}
	@Override
	public String ip() {

		return "trop.g.akliz.net";
	}
	@Override
	public String iconName() {
		return "trop";
	}
};	
public static ISupportedServer OtisSiegeServer = new ISupportedServer() {
	@Override
	public String name() {
		return "The LOTR Siege Server";
	}
	@Override
	public String ip() {

		return "LOTRSiege.beastmc.com";
	}
	@Override
	public String iconName() {
		return "siege";
	}
};	 
public static ISupportedServer SecondServerThatWillNotRuleAnything = new ISupportedServer() {
	@Override
	public String name() {
		return "The Second Server That Wont Rule Anything";
	}
	@Override
	public String ip() {

		return "54.39.28.42";
	}
	@Override
	public String iconName() {
		return "second";
	}
};	
public static ISupportedServer SecondServerThatWillNotRuleAnything2 = new ISupportedServer() {
	@Override
	public String name() {
		return "The Second Server That Wont Rule Anything";
	}
	@Override
	public String ip() {

		return "54.39.28.42:25566";
	}
	@Override
	public String iconName() {
		return "second";
	}
};	
public static ISupportedServer SecondServerThatWillNotRuleAnything3 = new ISupportedServer() {
	@Override
	public String name() {
		return "The Second Server That Wont Rule Anything";
	}
	@Override
	public String ip() {

		return "54.39.28.42:25566";
	}
	@Override
	public String iconName() {
		return "second";
	}
};	
public static ISupportedServer DOME = new ISupportedServer() {
	@Override
	public String name() {
		return "Dominion of Middle-Earth";
	}
	@Override
	public String ip() {

		return "dominion.g.akliz.net";
	}
	@Override
	public String iconName() {
		return "dome";
	}
};	
public static ISupportedServer Ascension = new ISupportedServer() {
	@Override
	public String name() {
		return "Ascension d’Arda";
	}
	@Override
	public String ip() {

		return "149.202.121.115:27220";
	}
	@Override
	public String iconName() {
		return "asc";
	}
};	
public static ISupportedServer Edgorovs = new ISupportedServer() {
	@Override
	public String name() {
		return "LOTR: Edgorovs Realm";
	}
	@Override
	public String ip() {

		return "edgorovsrealm.apexmc.co";
	}
	@Override
	public String iconName() {
		return "engov";
	}
};
public static ISupportedServer Champ = new ISupportedServer() {
	@Override
	public String name() {
		return "The Champions Game";
	}
	@Override
	public String ip() {

		return "tcg.apexmc.co";
	}
	@Override
	public String iconName() {
		return "cg";
	}
};
	
	private static final Map<String, ISupportedServer> servers = new HashMap<>();
	private static ArrayList<String> serverList = new ArrayList<String>();
	
	public static void initServers() {
		addServer(TOS);
		addServer(LOTRSurvival);
		addServer(TheRingOfPower);
		addServer(OtisSiegeServer);
		addServer(SecondServerThatWillNotRuleAnything);
		addServer(SecondServerThatWillNotRuleAnything2);
		addServer(SecondServerThatWillNotRuleAnything3);
		addServer(DOME);
		addServer(Ascension);
		addServer(Edgorovs);
		addServer(Champ);


	}
	public static void addServer(ISupportedServer server) {
		getServers().put(server.ip(), server);
	}
	public static Map<String, ISupportedServer> getServers() {
		return servers;
	}
}
