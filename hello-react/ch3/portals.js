class Table extends React.Component {
    render() {
        return ReactDOM.createPortal(
            this.props.children,
            domNode
        )
    }
}