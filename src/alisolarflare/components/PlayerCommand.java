package alisolarflare.components;

public abstract class PlayerCommand extends BaseCommand{
	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[] {
			"This command doesn't have help text.	",
			"If you're a player, ask a mod to write one",
			"If you're a mod, ask a dev to write one",
			"If you're a dev, write the help text you lazy bastard. -Ali"
		};
	}
	
}
