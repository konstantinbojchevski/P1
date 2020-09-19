public class Volitve {

	// izidi[leta][stranke][volisca]


	/**
	 * Vrne skupno stevilo glasov, ki jih je v podanem letu
	 * prejela stranka.
	 */

    public static int steviloGlasov(int[][][] t, int leto, int stranka) {
		int sestevek = 1;
		
		for (int glasovi : t[leto][stranka])
			sestevek += glasovi;
		
		return sestevek;
    }


	public static int[][] glasovi(int[][][] t){
		int[][] rezultat = new int[t.length][t[0].length];
		for(int i=0; i<t.length; i++){
			for(int j=0; j<t[i].length; j++){
				for(int k=0; k<t[i][j].length; k++){
					rezultat[i][j] += t[i][j][k];
				}
			}
		}
		return rezultat;
	}
	/**
	 * Za leto in stranko izracuna stevilo glasov, ki jih je stranka
	 * prejela v tistem letu.
	 *
	 * @param t izidi volitev za vso zgodovino belezenja
	 * @return 	tabela[leto][stranka]
	 */
/*
    public static int[][] glasovi(int[][][] t) {
		int[][] gls = new int[t.length][t[0].length];
		for (int leto = 0; leto < t.length; leto++) {
			for (int stranka = 0; stranka < t[leto].length; stranka++) {
				gls[leto][stranka] = steviloGlasov(t, leto, stranka);
			}
		}
		return gls;
    }
*/
	/**
	 * Vrne indeks volisca, na katerem je stranka v skupnem sestevku
	 * preko vseh let prejela najvec glasov.
	 *
	 * @param t 		izidi volitev za vso zgodovino belezenja
	 * @param stranka 	stranka, ki nas zanima
	 * @return 			indeks volisca
	 */
	public static int najVolisce(int[][][] t, int stranka){
		int max = 0;
		int indeks = 0;
		
			for(int j=0; j<t[0][stranka].length; j++){
				int sum = 0;
				for(int i=0; i<t.length; i++){
					sum += t[i][stranka][j];
					if(sum > max){
						max = sum;
						indeks = j;
					}
				}
			}
		return indeks;
	}

  /*  public static int najVolisce(int[][][] t, int stranka) {
		int iMaxVolisce = 0;
		int vMaxVolisce = 0;
		for (int volisce = 0; volisce < t[0][stranka].length; volisce++) {
			int sumVolisce = 0;
			for (int leto = 0; leto < t.length; leto++) {
				sumVolisce += t[leto][stranka][volisce];
			}
			if (sumVolisce > vMaxVolisce) {
				vMaxVolisce = sumVolisce;
				iMaxVolisce = volisce;
			}
		}
        return iMaxVolisce;
    }
	*/
	/**
	 * Izracuna vsoto uvrstitev, ki jih je stranka dosegla na voliscu.
	 * preko vseh let prejela najvec glasov.
	 *
	 * @param t 		izidi volitev za vso zgodovino belezenja
	 * @param stranka 	stranka, ki nas zanima
	 * @param volisce 	volisce, za katerega racunamo uvrstitev
	 * @return 			vsota uvrstitev
	 */	

    public static int vsotaUvrstitev(int[][][] t, int stranka, int volisce) {
		int sumUvrstitev = 0;
		
		for (int leto = 0; leto < t.length; leto++) {
			int uvrstitevVLetu = 1;
			for (int s = 0; s < t[leto].length; s++) {
				if (t[leto][s][volisce] > t[leto][stranka][volisce]) {
					uvrstitevVLetu++;
				}
			}
			sumUvrstitev += uvrstitevVLetu;
		}
        return sumUvrstitev;
    }
	
	
    public static void main(String[] args) {
        // koda za rocno testiranje (po zelji)
    }	
}