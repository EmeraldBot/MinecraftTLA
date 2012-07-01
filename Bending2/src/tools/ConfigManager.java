package tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {

	public static boolean enabled = true;
	public static boolean colors = true;
	public static boolean compatibility = true;
	public static int airdmg = 1;
	public static int earthdmg = 7;
	public static int waterdmg = 7;
	public static Map<String, String> prefixes = new HashMap<String, String>();
	public static Map<String, String> color = new HashMap<String, String>();
	public static List<String> earthbendable = new ArrayList<String>();
	public static Map<String, Boolean> useWeapon = new HashMap<String, Boolean>();
	
	
	public static int airBlastSpeed = 25;
	public static int airBlastRange = 20;
	public static int airBlastRadius = 2;
	public static int airBlastPush = 1;
	public static int airBubbleRadius = 7;
	public static float airPassiveFactor = 0.3F;
	public static int airShieldRadius = 7;
	public static int airSuctionSpeed = 25;
	public static int airSuctionRange = 20;
	public static int airSuctionRadius = 2;
	public static int airSuctionPush = 1;
	public static int airSwipeRange = 16;
	public static int airSwipeArc = 20;
	public static int airSwipeSpeed = 25;
	public static int airSwipeRadius = 2;
	public static int airSwipePush = 1;
	public static int airSwipeCooldown = 1000;
	public static int tornadoRadius = 10;
	public static int tornadoHeight = 25;
	public static int tornadoRange = 25;
	public static int tornadoMobPush = 1;
	public static int tornadoPlayerPush = 1;
	public static int catapultLength = 7;
	public static int catapultSpeed = 12;
	public static int catapultPush = 5;
	public static int compactColumnRange = 20;
	public static int compactColumnSpeed = 8;
	public static int earthBlastRange = 20;
	public static int earthBlastSpeed = 35;
	public static int earthColumnHeight = 6;
	public static int earthGrabRange = 15;
	public static int earthPassive = 3000;
	public static int earthTunnelMaxRadius = 1;
	public static int earthTunnelRange = 10;
	public static double earthTunnelRadius = 0.25;
	public static int earthTunnelInterval = 30;
	public static int earthWallRange = 15;
	public static int earthWallHeight = 8;
	public static int earthWallWidth = 6;
	public static int collapseRange = 20;
	public static int collapseRadius = 7;
	public static int arcOfFireArc = 20;
	public static int extinguishRange = 20;
	public static int extinguishRadius = 20;
	public static int fireballCooldown = 1000;
	public static double fireballSpeed = 0.3;
	public static double fireJetSpeed = 0.6;
	public static int fireJetDuration = 2000;
	public static int fireJetCooldown = 6000;
	public static int fireStreamSpeed = 20;
	public static int fireStreamRange = 20;
	public static int heatMeltRange = 20;
	public static int heatMeltRadius = 5;
	public static int freezeMeltRange = 20;
	public static int freezeMeltRadius = 5;
	public static int healingWatersRadius = 5;
	public static int healingWatersInterval = 750;
	public static int plantbendingRange = 10;
	public static int walkOnWaterRadius = 3;
	public static int waterManipulationRange = 20;
	public static int waterManipulationSpeed = 35;
	public static int waterSpoutHeight = 8;
	public static int waterWallRange = 5;
	public static int waterWallRadius = 2;
	public static int waveRadius = 3;
	public static int waveHorizontalPush = 1;
	public static double waveVerticalPush = 0.2;
	public static int globalCooldown = 500;
	

	private static List<String> defaultearthbendable = new ArrayList<String>();

	public void load(File file) {
		FileConfiguration config = new YamlConfiguration();
		try {
			if (file.exists())
				config.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		config.setDefaults(getDefaults());

		colors = config.getBoolean("Chat.Colors");

		airdmg = config.getInt("Bending.Damage.AirSwipe");

		enabled = config.getBoolean("Chat.Enabled");

		compatibility = config.getBoolean("Chat.Compatibility");

		waterdmg = config.getInt("Bending.Damage.WaterManipulation");

		earthdmg = config.getInt("Bending.Damage.EarthBlast");

		prefixes.put("Air", config.getString("Chat.Prefix.Air"));
		prefixes.put("Avatar", config.getString("Chat.Prefix.Avatar"));
		prefixes.put("Fire", config.getString("Chat.Prefix.Fire"));
		prefixes.put("Water", config.getString("Chat.Prefix.Water"));
		prefixes.put("Earth", config.getString("Chat.Prefix.Earth"));

		color.put("Avatar", config.getString("Chat.Color.Avatar"));
		color.put("Air", config.getString("Chat.Color.Air"));
		color.put("Fire", config.getString("Chat.Color.Fire"));
		color.put("Water", config.getString("Chat.Color.Water"));
		color.put("Earth", config.getString("Chat.Color.Earth"));

		earthbendable = config.getStringList("Bending.Option.EarthBendable");

		useWeapon.put("Air",
				config.getBoolean("Bending.Option.Bend-With-Weapon.Air"));
		useWeapon.put("Earth",
				config.getBoolean("Bending.Option.Bend-With-Weapon.Earth"));
		useWeapon.put("Fire",
				config.getBoolean("Bending.Option.Bend-With-Weapon.Fire"));
		useWeapon.put("Water",
				config.getBoolean("Bending.Option.Bend-With-Weapon.Water"));
						//PROPERTIES
		globalCooldown = config.getInt("Properties.GolbalCooldown");
							//AIR
		//AirBlast
		airBlastSpeed = config.getInt("Properties.Air.AirBlast.Speed");
		airBlastRange = config.getInt("Properties.Air.AirBlast.Range");
		airBlastRadius = config.getInt("Properties.Air.AirBlast.Affecting-Radius");
		airBlastPush = config.getInt("Properties.Air.AirBlast.Push-Factor");
		//AirBubble
		airBubbleRadius = config.getInt("Properties.Air.AirBubble.Radius");
		//AirPassive
		airPassiveFactor = config.getInt("Properties.Air.Passive.Factor");
		//AirShield
		airShieldRadius = config.getInt("Properties.Air.AirShield.Radius");
		//AirSuction
		airSuctionSpeed = config.getInt("Properties.Air.AirSuction.Speed");
		airSuctionRange = config.getInt("Properties.Air.AirSuction.Range");
		airSuctionRadius = config.getInt("Properties.Air.AirSuction.Affecting-Radius");
		airSuctionPush = config.getInt("Properties.Air.AirSuction.Push-Factor");
		//AirSwipe
		airSwipeRange = config.getInt("Properties.Air.AirSwipe.Range");
		airSwipeArc = config.getInt("Properties.Air.AirSwipe.Arc");
		airSwipeSpeed =config.getInt("Properties.Air.AirSwipe.Speed");
		airSwipeRadius = config.getInt("Properties.Air.AirSwipe.Affecting-Radius");
		airSwipePush = config.getInt("Properties.Air.AirSwipe.Push-Factor");
		airSwipeCooldown = config.getInt("Properties.Air.AirSwipe.Cooldown");
		//Tornado
		tornadoRadius = config.getInt("Properties.Air.Tornado.Radius");
		tornadoHeight = config.getInt("Properties.Air.Tornado.Height");
		tornadoRange = config.getInt("Properties.Air.Tornado.Range");
		tornadoMobPush = config.getInt("Properties.Air.Tornado.Mob-Push-Factor");
		tornadoPlayerPush = config.getInt("Properties.Air.Tornado.Player-Push-Factor");
						//EARTH
		//Catapult
		catapultLength = config.getInt("Properties.Earth.Catapult.Length");
		catapultSpeed = config.getInt("Properties.Earth.Catapult.Speed");
		catapultPush = config.getInt("Properties.Earth.Catapult.Push");
		//CompactColumn
		compactColumnRange = config.getInt("Properties.Earth.CompactColumn.Range");
		compactColumnSpeed = config.getInt("Properties.Earth.CompactColumn.Speed");
		//EarthBlast
		earthBlastRange = config.getInt("Properties.Earth.EarthBlast.Range");
		earthBlastSpeed = config.getInt("Properties.Earth.EarthBlast.Speed");
		//EarthColumn
		earthColumnHeight = config.getInt("Properties.Earth.EarthColumn.Height");
		//EarthGrab
		earthGrabRange = config.getInt("Properties.Earth.EarthGrab.Range");
		//EarthPassive
		earthPassive = config.getInt("Properties.Earth.EarthPassive.Wait-Before-Reverse-Changes");
		//EarthTunnel
		earthTunnelMaxRadius = config.getInt("Properties.Earth.EarthTunnel.Max-Radius");
		earthTunnelRange = config.getInt("Properties.Earth.EarthTunnel.Range");
		earthTunnelRadius = config.getInt("Properties.Earth.EarthTunnel.Radius");
		earthTunnelInterval = config.getInt("Properties.Earth.EarthTunnel.Interval");
		//EarthWall
		earthWallRange = config.getInt("Properties.Earth.EarthWall.Range");
		earthWallHeight = config.getInt("Properties.Earth.EarthWall.Height");
		earthWallWidth = config.getInt("Properties.Earth.EarthWall.Width");
		//Collapse
		collapseRange = config.getInt("Properties.Earth.Collapse.Range");
		collapseRadius = config.getInt("Properties.Earth.Collapse.Radius");
							//FIRE
		//ArcOfFire
		arcOfFireArc = config.getInt("Properties.Fire.ArcOfFire.Arc");
		//Extinguish
		extinguishRange = config.getInt("Properties.Fire.Extinguish.Range");
		extinguishRadius = config.getInt("Properties.Fire.Extinguish.Radius");
		//Fireball
		fireballCooldown = config.getInt("Properties.Fire.Fireball.Cooldown");
		fireballSpeed = config.getInt("Properties.Fire.Fireball.Speed");
		//FireJet
		fireJetSpeed =config.getInt("Properties.Fire.FireJet.Speed");
		fireJetDuration = config.getInt("Properties.Fire.FireJet.Duration");
		fireJetCooldown = config.getInt("Properties.Fire.FireJet.CoolDown");
		//FireStream
		fireStreamSpeed = config.getInt("Properties.Fire.FireStream.Speed");
		fireStreamRange = config.getInt("Properties.Fire.FireStream.Range");
		//HeatMelt
		heatMeltRange = config.getInt("Properties.Fire.HeatMelt.Range");
		heatMeltRadius = config.getInt("Properties.Fire.HeatMelt.Radius");
							//WATER
		//FreezeMelt
		freezeMeltRange = config.getInt("Properties.Water.FreezeMelt.Range");
		freezeMeltRadius = config.getInt("Properties.Water.FreezeMelt.Radius");
		//HealingWaters
		healingWatersRadius = config.getInt("Properties.Water.HealingWaters.Radius");
		healingWatersInterval = config.getInt("Properties.Water.HealingWaters.Interval");
		//Plantbending
		plantbendingRange = config.getInt("Properties.Water.Plantbending.Range");
		//WalkOnWater
		walkOnWaterRadius = config.getInt("Properties.Water.WalkOnWater.Radius");
		//WaterManipulation
		waterManipulationRange = config.getInt("Properties.Water.WaterManipulation.Range");
		waterManipulationSpeed = config.getInt("Properties.Water.WaterManipulation.Speed");
		//WaterSpout
		waterSpoutHeight = config.getInt("Properties.Water.WaterSpout.Height");
		//WaterWall
		waterWallRange = config.getInt("Properties.Water.WaterWall.Range");
		waterWallRadius = config.getInt("Properties.Water.WaterWall.Radius");
		//Wave
		waveRadius = config.getInt("Properties.Water.Wave.Radius");
		waveHorizontalPush = config.getInt("Properties.Water.Wave.Horizontal-Push-Force");
		waveVerticalPush = config.getInt("Properties.Water.Wave.Vertical-Push-Force");

		try {
			config.options().copyDefaults(true);
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private MemoryConfiguration getDefaults() {
		MemoryConfiguration config = new MemoryConfiguration();
		config.set("Chat.Enabled", Boolean.valueOf(true));
		config.set("Chat.Colors", Boolean.valueOf(true));
		config.set("Chat.Compatibility", Boolean.valueOf(false));
		config.set("Chat.Prefix.Avatar", "[Avatar] ");
		config.set("Chat.Prefix.Air", "[Airbender] ");
		config.set("Chat.Prefix.Fire", "[Firebender] ");
		config.set("Chat.Prefix.Water", "[Waterbender] ");
		config.set("Chat.Prefix.Earth", "[Earthbender] ");
		config.set("Bending.Damage.AirSwipe", Integer.valueOf(2));
		config.set("Bending.Damage.EarthBlast", Integer.valueOf(7));
		config.set("Bending.Damage.WaterManipulation", Integer.valueOf(5));
		config.set("Chat.Color.Avatar", "DARK_PURPLE");
		config.set("Chat.Color.Air", "GRAY");
		config.set("Chat.Color.Fire", "RED");
		config.set("Chat.Color.Water", "AQUA");
		config.set("Chat.Color.Earth", "GREEN");
		config.set("Bending.Option.EarthBendable", defaultearthbendable);
		config.set("Bending.Option.Bend-With-Weapon.Air", false);
		config.set("Bending.Option.Bend-With-Weapon.Fire", true);
		config.set("Bending.Option.Bend-With-Weapon.Water", true);
		config.set("Bending.Option.Bend-With-Weapon.Earth", true);
		
		config.set("Properties.GolbalCooldown", 500);
		
		config.set("Properties.Air.AirBlast.Speed", 25);
		config.set("Properties.Air.AirBlast.Range", 20);
		config.set("Properties.Air.AirBlast.Affecting-Radius", 2);
		config.set("Properties.Air.AirBlast.Push-Factor", 1);
		
		config.set("Properties.Air.AirBubble.Radius", 5);
		
		config.set("Properties.Air.Passive.Factor", 0.3F);
		
		config.set("Properties.Air.AirShield.Radius", 7);
		
		config.set("Properties.Air.AirSuction.Speed", 25);
		config.set("Properties.Air.AirSuction.Range", 20);
		config.set("Properties.Air.AirSuction.Affecting-Radius", 2);
		config.set("Properties.Air.AirSuction.Push-Factor", 1);
		
		config.set("Properties.Air.AirSwipe.Range", 16);
		config.set("Properties.Air.AirSwipe.Arc", 20);
		config.set("Properties.Air.AirSwipe.Speed", 25);
		config.set("Properties.Air.AirSwipe.Affecting-Radius", 2);
		config.set("Properties.Air.AirSwipe.Push-Factor", 1);
		config.set("Properties.Air.AirSwipe.Cooldown", 1000);
		
		config.set("Properties.Air.Tornado.Radius", 10);
		config.set("Properties.Air.Tornado.Height", 25);
		config.set("Properties.Air.Tornado.Range", 25);
		config.set("Properties.Air.Tornado.Mob-Push-Factor", 1);
		config.set("Properties.Air.Tornado.Player-Push-Factor", 1);
		
		
		config.set("Properties.Earth.Catapult.Length", 7);
		config.set("Properties.Earth.Catapult.Speed", 12);
		config.set("Properties.Earth.Catapult.Push", 5);
		
		config.set("Properties.Earth.CompactColumn.Range", 20);
		config.set("Properties.Earth.CompactColumn.Speed", 8);
		
		config.set("Properties.Earth.EarthBlast.Range", 20);
		config.set("Properties.Earth.EarthBlast.Speed", 35);
		
		config.set("Properties.Earth.EarthColumn.Height", 6);
		
		config.set("Properties.Earth.EarthGrab.Range", 15);
		
		config.set("Properties.Earth.EarthPassive.Wait-Before-Reverse-Changes", 3000);
		
		config.set("Properties.Earth.EarthTunnel.Max-Radius", 1);
		config.set("Properties.Earth.EarthTunnel.Range", 10);
		config.set("Properties.Earth.EarthTunnel.Radius", 0.25);
		config.set("Properties.Earth.EarthTunnel.Interval", 30);
		
		config.set("Properties.Earth.EarthWall.Range", 15);
		config.set("Properties.Earth.EarthWall.Height", 8);
		
		config.set("Properties.Earth.EarthWall.Width", 6);
		
		config.set("Properties.Earth.Collapse.Range", 20);
		config.set("Properties.Earth.Collapse.Radius", 7);
		
		
		config.set("Properties.Fire.ArcOfFire.Arc", 20);
		
		config.set("Properties.Fire.Extinguish.Range", 20);
		config.set("Properties.Fire.Extinguish.Radius", 20);
		
		config.set("Properties.Fire.Fireball.Cooldown", 1000);
		config.set("Properties.Fire.Fireball.Speed", 0.3);
		
		config.set("Properties.Fire.FireJet.Speed", 0.6);
		config.set("Properties.Fire.FireJet.Duration", 2000);
		config.set("Properties.Fire.FireJet.CoolDown", 6000);
		
		config.set("Properties.Fire.FireStream.Speed", 20);
		config.set("Properties.Fire.FireStream.Range", 20);
		
		config.set("Properties.Fire.HeatMelt.Range", 20);
		config.set("Properties.Fire.HeatMelt.Radius", 6000);
		
		
		config.set("Properties.Water.FreezeMelt.Range", 20);
		config.set("Properties.Water.FreezeMelt.Radius", 5);
		
		config.set("Properties.Water.HealingWaters.Radius", 5);
		config.set("Properties.Water.HealingWaters.Interval", 750);
		
		config.set("Properties.Water.Plantbending.Range", 10);
		
		config.set("Properties.Water.WalkOnWater.Radius", 3);
		
		config.set("Properties.Water.WaterManipulation.Range", 20);
		config.set("Properties.Water.WaterManipulation.Speed", 35);
		
		config.set("Properties.Water.WaterSpout.Height", 8);
		
		config.set("Properties.Water.WaterWall.Range", 5);
		config.set("Properties.Water.WaterWall.Radius", 2);
		
		config.set("Properties.Water.Wave.Radius", 3);
		config.set("Properties.Water.Wave.Horizontal-Push-Force", 1);
		config.set("Properties.Water.Wave.Vertical-Push-Force", 0.2);
		
		return config;
	}

	public static String getColor(String element) {
		return color.get(element);
	}

	public static String getPrefix(String element) {
		return prefixes.get(element);
	}

	static {
		defaultearthbendable.add("STONE");

		defaultearthbendable.add("CLAY");

		defaultearthbendable.add("COAL_ORE");

		defaultearthbendable.add("DIAMOND_ORE");

		defaultearthbendable.add("DIRT");

		defaultearthbendable.add("GOLD_ORE");

		defaultearthbendable.add("GRASS");

		defaultearthbendable.add("GRAVEL");

		defaultearthbendable.add("IRON_ORE");

		defaultearthbendable.add("LAPIS_ORE");

		defaultearthbendable.add("NETHERRACK");

		defaultearthbendable.add("REDSTONE_ORE");

		defaultearthbendable.add("SAND");

		defaultearthbendable.add("SANDSTONE");

	}
}