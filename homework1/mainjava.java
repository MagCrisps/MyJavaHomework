package myjavaproject;
	public class mainjava {
		public long[] findthearr(long ...x) {
			int i, j, k;
			for( i = 0; i < x.length - 1; i ++) {
				k = i;
				for(j = i + 1; j < x.length; j ++) {
					if(x[j] < x[k]) {
						k = j;
					}
				}
				if(k != i) {
					long temp = x[k];
					x[k] = x[i];
					x[i] = temp;
				}else {
					break;
				}
			}
			return x;
		}
}

