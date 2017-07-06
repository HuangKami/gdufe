	<div style="margin: 20px">
		<form action="userInfo" method="post">
			<input type="submit" value="查询用户信息">
		</form>
	</div>
	<div style="margin: 20px">
		<form action="cashInfo" method="post">
			<input type="submit" value="饭卡余额">
		</form>
	</div>
	<div style="margin: 20px">
		<form action="cashRecordInfo" method="post">
			<input type="submit" value="查询饭卡交易记录">
		</form>
	</div>
	<div style="margin: 20px">
		<h2>查询成绩</h2>
		<form action="gradeInfo" method="post">
			时间： <select name="stu_time">
				<option>2014-2015-1</option>
				<option>2014-2015-2</option>
				<option>2015-2016-1</option>
				<option>2015-2016-2</option>
				<option>2016-2017-1</option>
				<option>2016-2017-2</option>
				<option>整个大学</option>
			</select> <input type="submit" value="查询">
		</form>
	</div>

	<div style="margin: 20px">
		<h2>查询课程表</h2>
		<form action="courcesInfo" method="post">
			时间： <select name="stu_time">
				<option>2014-2015-1</option>
				<option>2014-2015-2</option>
				<option>2015-2016-1</option>
				<option>2015-2016-2</option>
				<option>2016-2017-1</option>
				<option>2016-2017-2</option>
				<option>整个大学</option>
			</select> <input type="submit" value="查询">
		</form>
	</div>

	<div style="margin: 20px">
		<form action="hisBollowed" method="post">
			<input type="submit" value="查询历史借阅">
		</form>
	</div>
	<div style="margin: 20px">
		<form action="nowBollowed" method="post">
			<input type="submit" value="查询当前借阅">
		</form>
	</div>
	<div style="margin: 20px">
		<h2>查询图书</h2>
		<form action="bookInfo" method="post">
			书名: <input type="text" name="bookName"> <input type="submit"
				value="查询">
		</form>
	</div>