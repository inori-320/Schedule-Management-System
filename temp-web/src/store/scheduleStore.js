import { defineStore } from "pinia";

export const defineSchedule = defineStore(
    "scheduleList",
    {
        state: () => {
            return {
                itemList: [
                    {
                        uid: 0,
                        title: "",
                        complete: false
                    }
                ]
            }
        },
        getters: () => {

        },
        actions: () => {

        }
    }
);