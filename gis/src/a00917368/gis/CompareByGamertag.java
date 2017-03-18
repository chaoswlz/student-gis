package a00917368.gis;

import java.util.Comparator;

import a00917368.data.Persona;

public class CompareByGamertag implements Comparator<Persona> {

	@Override
	public int compare(Persona firstPersona, Persona secondPersona) {
		return firstPersona.getGameTag().compareTo(secondPersona.getGameTag());
	}

}
