package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		String[] donne= controlLibererEtal.libererEtal(nomVendeur);
		StringBuilder text = new StringBuilder();
		if (donne!= null && donne[0].equals("true")) {
			
			text.append("Vous avez vendu "+donne[4]+" sur "+donne[3]+" produit.\n");
			text.append("Au revoir "+nomVendeur+", passez un bon voyage.");
			System.out.println(text);
		}
		else {
			System.out.println("Mais vous n'etes pas sur notre marche.");
		}
	}

}
