import {createSearchParams, useNavigate, useParams, useSearchParams} from "react-router-dom";
import {useCallback} from "react";

const ReadPage = () => {
    const {tno} = useParams()
    const navigate = useNavigate()
    const [queryParams] = useSearchParams()

    const page = queryParams.get("page") ? parseInt(queryParams.get("page")) : 1
    const size = queryParams.get("size") ? parseInt(queryParams.get("size")) : 10

    const queryStr = createSearchParams({page,size}).toString()

    const moveToModify = useCallback((tno)=> {
        navigate({
            pathname:`/todo/modify/${tno}`,
            search: queryStr
        })
    },[navigate, queryStr])

    const moveToList = useCallback(()=>{
        navigate({
            pathname: `/todo/list`,
            search: queryStr
        })
    }, [navigate, queryStr])

    return (
        <div className="text-3xl font-extrabold">
            Todo Read Page Component {tno}
            <div>
                <button onClick={()=>moveToModify(33)}>Test Modify</button>
                <button onClick={()=>moveToList()}>Test List</button>
            </div>
        </div>
    )
}

export default ReadPage;