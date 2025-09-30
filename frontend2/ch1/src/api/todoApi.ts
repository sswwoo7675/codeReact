import axios from "axios"

export const API_SERVER_HOST = 'http://localhost:8080'

const prefix = `${API_SERVER_HOST}/api/todo`;

export const getOne = async (tno: number | string) => {
  const res = await axios.get(`${prefix}/${tno}`);

  return res.data;
}

export const getList = async (pageParam: PageParam) => {
  const res = await axios.get(`${prefix}/list`,{params: pageParam});

  return res.data;
}