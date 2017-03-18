/**
 * Project: A00917368Gis
 * File: CompareByCount.java
 * Date: May 15, 2015
 * Time: 8:19:39 PM
 */

package a00917368.gis;

import java.util.Comparator;

import a00917368.data.Print;

/**
 * @author Lize Wu A00917368
 *
 */
public class CompareByCount implements Comparator<Print> {

	@Override
	public int compare(Print firstPrint, Print secondPrint) {
		return firstPrint.getResult().compareTo(secondPrint.getResult());
	}

}
