import * as React from 'react';
// import './App.css';
import DragAndDropSidebar from "./DragAndDropSidebar";



class App extends React.Component {

	render() {
		const searchParams = new URLSearchParams(document.location.search)
		console.log("params: ", searchParams.get('reason'));

		console.log(this.props)

		return (
			<div className="app-box">
				<DragAndDropSidebar />
			</div>
		);
	}
}

export default App;