package alisolarflare.components;

import buttondevteam.lib.chat.TBMCCommandBase;

public abstract class PlayerCommand extends TBMCCommandBase{
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
		return new String[] {"This command doesn't have help text, ask a mod to ask a dev to add one, using public String[] GetHelpText. "
				+ "If you're a mod, ask a dev to write the help text." +
				  "If you're a dev, write the help text you lazy bastard. -Ali"};
	}
	
}
