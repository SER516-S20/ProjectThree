
public class ButtonBoxFactory {
	public static ButtonBox buildButtonBox( String btnCommand) {
		ButtonBox button = null;
		switch(btnCommand) {
		case "(":
			break;
		case ")":
			break;
		case "<":
			button = new LButtonBox();
			break;
		case ">":
			button = new RButtonBox();
			break;
		case "@":
			break;
		case "||":
			break;
		case "-" :
			break;
		}
		return button;
		
	}
}
