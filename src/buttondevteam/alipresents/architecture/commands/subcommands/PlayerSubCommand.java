package buttondevteam.alipresents.architecture.commands.subcommands;

public abstract class PlayerSubCommand extends SubCommand{
	@Override
	public boolean getModOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPlayerOnly() {
		// TODO Auto-generated method stub
		return true;
	}

}
