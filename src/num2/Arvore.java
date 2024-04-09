package num2;

public class Arvore {

	class ArvoreBinaria {
		private No raiz;

		public ArvoreBinaria() {
			raiz = null;
		}

		public void inserir(int x) throws Exception {
			raiz = inserir(x, raiz);
		}

		private No inserir(int x, No i) throws Exception {
			if (i == null) {
				i = new No(x);
			} else if (x < i.elemento) {
				i.esq = inserir(x, i.esq);
			} else if (x > i.elemento) {
				i.dir = inserir(x, i.dir);
			} else {
				throw new Exception("Erro!");
			}
			return i;
		}

		public boolean pesquisar(int x) {
			return pesquisar(x, raiz);
		}

		private boolean pesquisar(int x, No i) {
			boolean resp;
			if (i == null) {
				resp = false;
			} else if (x == i.elemento) {
				resp = true;
			} else if (x < i.elemento) {
				resp = pesquisar(x, i.esq);
			} else {
				resp = pesquisar(x, i.dir);
			}
			return resp;
		}

		public void caminharCentral() {
			caminharCentral(raiz);
		}

		private void caminharCentral(No i) {
			if (i != null) {
				caminharCentral(i.esq);
				System.out.print(i.elemento + "");
				caminharCentral(i.dir);
			}
		}

		public void caminharPre() {
			caminharPre(raiz);
		}

		private void caminharPre(No i) {
			if (i != null) {
				System.out.print(i.elemento + "");
				caminharPre(i.esq);
				caminharPre(i.dir);
			}
		}

		public void caminharPos() {
			caminharPos(raiz);
		}

		private void caminharPos(No i) {
			if (i != null) {
				caminharPos(i.esq);
				caminharPos(i.dir);
				System.out.print(i.elemento + "");
			}

		}

		public void remover(int x) throws Exception {
			raiz = remover(x, raiz);
		}

		 private No remover(int x, No i) throws Exception {
			if (i == null) {
				throw new Exception("Erro!");
			} else if (x < i.elemento) {
				i.esq = remover(x, i.esq);
			} else if (x > i.elemento) {
				i.dir = remover(x, i.dir);
			} else if (i.dir == null) {
			} else if (i.esq == null) {
				i = i.esq;
				i = i.dir;
			} else {
				i.esq = maiorEsq(i, i.esq);
			}
			return i;
		}

		private No maiorEsq(No i, No j) {
			if (j.dir == null) {
				i.elemento = j.elemento;
				j = j.esq;
			} else {
				j.dir = maiorEsq(i, j.dir);
			}
			return j;
		}
	}

}
