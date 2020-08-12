package com.jd.blockchain.utils;
/**
	 * {@link AbstractSkippingIterator} 提供了对 {@link SkippingIterator} 的基础实现；
	 * 
	 * <p>
	 * 
	 * 遍历的结果是得到一个数据差集：包含在新数据默克尔树中，但不包含在比较基准默克尔树中的数据集合；
	 * 
	 * @author huanghaiquan
	 *
	 * @param <T>
	 */
	public abstract class AbstractSkippingIterator<T> implements SkippingIterator<T> {

		//TODO: seal the access of cursor;
		protected long cursor = -1;

		public long getCursor() {
			return cursor;
		}

		@Override
		public boolean hasNext() {
			return cursor + 1 < getTotalCount();
		}

		/**
		 *
		 */
		public long skip(long skippingCount) {
			if (skippingCount < 0) {
				throw new IllegalArgumentException("The specified count is out of bound!");
			}
			if (skippingCount == 0) {
				return 0;
			}
			long count = getTotalCount();
			if (cursor + skippingCount < count) {
				cursor += skippingCount;
				return skippingCount;
			}
			long skipped = count - cursor - 1;
			cursor = count - 1;
			return skipped;
		}
		
		

	}